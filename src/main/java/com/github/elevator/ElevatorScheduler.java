package com.github.elevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Core object representing the elevator scheduler.
 * 
 * @author gaurav
 */
public final class ElevatorScheduler {
  private static final Logger logger =
      LogManager.getLogger(ElevatorScheduler.class.getSimpleName());

  private final ElevatorGroup elevatorGroup;
  private final Map<String, PriorityBlockingQueue<ElevatorInternalRequest>> elevatorInternalRequestMap =
      new HashMap<>();
  private final List<ElevatorExternalRequest> elevatorExternalRequests = new ArrayList<>();
  private final Map<String, ElevatorRunner> elevatorRunners = new HashMap<>();

  public ElevatorScheduler(final ElevatorGroup elevatorGroup) {
    Thread.currentThread().setName("elevator-scheduler");
    this.elevatorGroup = elevatorGroup;
  }

  public synchronized void init() {
    logger.info("Initializing scheduler");
    for (final Elevator elevator : elevatorGroup.getElevators()) {
      elevatorInternalRequestMap.put(elevator.getId(),
          new PriorityBlockingQueue<ElevatorInternalRequest>());
      elevatorRunners.put(elevator.getId(),
          new ElevatorRunner(elevator, elevatorInternalRequestMap.get(elevator.getId())));
    }
    logger.info("Initialized scheduler");
  }

  public synchronized void tini() {
    logger.info("Stopping scheduler");
    for (final ElevatorRunner elevatorRunner : elevatorRunners.values()) {
      elevatorRunner.interrupt();
    }
    logger.info("Stopped scheduler");
  }

  /**
   * As part of scheduling, a request goes through multiple phases: <br/>
   * 1. Received:: request arrives and needs to be routed <br/>
   * 2. Pending-scheduling:: request waits in a global buffer waiting to be routed <br/>
   * 3. Scheduled:: request is routed and placed in an elevator's queue <br/>
   * 4. Completed:: request is completed by the elevator <br/>
   * 5. Failed:: a non-Completed request can reach Failed phase from any phase <br/>
   */
  public void scheduleRequest(final ElevatorRequest request) {
    logger.info("Received for scheduling {}", request);
    request.setRequestState(ElevatorRequestState.PENDING_SCHEDULING);

    if (ElevatorInternalRequest.class.isAssignableFrom(request.getClass())) {
      final ElevatorInternalRequest internalRequest = ElevatorInternalRequest.class.cast(request);
      final PriorityBlockingQueue<ElevatorInternalRequest> elevatorInternalRequests =
          elevatorInternalRequestMap.get(internalRequest.getElevatorId());
      elevatorInternalRequests.add(internalRequest);
    }

    else if (ElevatorExternalRequest.class.isAssignableFrom(request.getClass())) {
      final ElevatorExternalRequest externalRequest = ElevatorExternalRequest.class.cast(request);
      elevatorExternalRequests.add(externalRequest);
    }
  }

  public void unscheduleRequest(final ElevatorRequest request) {
    logger.info("Received for unscheduling {}", request);
    // TODO
  }

  /**
   * Worker thread responsible for serving requests for an elevator.
   * 
   * @author gaurav
   */
  public static final class ElevatorRunner extends Thread {
    private static final Logger logger = LogManager.getLogger(ElevatorRunner.class.getSimpleName());

    private final Elevator elevator;
    private final PriorityBlockingQueue<ElevatorInternalRequest> elevatorInternalRequests;

    public ElevatorRunner(final Elevator elevator,
        final PriorityBlockingQueue<ElevatorInternalRequest> elevatorInternalRequests) {
      setName("runner-" + elevator.getId());
      setDaemon(true);

      this.elevator = elevator;
      this.elevator.setMode(ElevatorOperationMode.NORMAL);

      this.elevatorInternalRequests = elevatorInternalRequests;

      start();
    }

    @Override
    public void run() {
      logger.info("Servicing requests");
      while (!isInterrupted()) {
        try {
          while (!elevatorInternalRequests.isEmpty()) {
            int currentFloor = elevator.getCurrentFloor();
            ElevatorDirection direction = elevator.getDirection();
            elevatorInternalRequests.peek();
          }
          sleep(100L);
        } catch (InterruptedException problem) {
        }
      }
      this.elevator.setMode(ElevatorOperationMode.STOPPING);
      this.elevator.setMode(ElevatorOperationMode.STOPPED);
      logger.info("Stopped");
    }
  }

}
