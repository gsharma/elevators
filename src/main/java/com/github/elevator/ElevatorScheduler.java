package com.github.elevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Core object representing the elevator scheduler.
 * 
 * @author gaurav
 */
public final class ElevatorScheduler {
  private final ElevatorGroup elevatorGroup;
  private final Map<String, Set<ElevatorInternalRequest>> elevatorInternalRequestMap =
      new HashMap<>();

  public ElevatorScheduler(final ElevatorGroup elevatorGroup) {
    this.elevatorGroup = elevatorGroup;
    for (final Elevator elevator : elevatorGroup.getElevators()) {
      elevatorInternalRequestMap.put(elevator.getId(), new TreeSet<ElevatorInternalRequest>());
    }
  }

  public void scheduleRequest(final ElevatorRequest request) {
    if (ElevatorInternalRequest.class.isAssignableFrom(request.getClass())) {
      final ElevatorInternalRequest internalRequest = ElevatorInternalRequest.class.cast(request);
      final Set<ElevatorInternalRequest> elevatorInternalRequests =
          elevatorInternalRequestMap.get(internalRequest.getElevatorId());
      elevatorInternalRequests.add(internalRequest);
    }

    else if (ElevatorExternalRequest.class.isAssignableFrom(request.getClass())) {
    }
  }

}
