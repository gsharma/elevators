package com.github.elevator;

import java.util.Comparator;

/**
 * Elevator scheduling request made from within the elevator.
 * 
 * @author gaurav
 */
public final class ElevatorInternalRequest
    implements ElevatorRequest, Comparator<ElevatorInternalRequest> {
  private final String elevatorGroupId;
  private final String elevatorId;
  private final int requestedFloor;

  private long scheduledAtMillis;
  private long completedAtMillis;

  public ElevatorInternalRequest(final String elevatorGroupId, final String elevatorId,
      final int requestedFloor) {
    this.elevatorGroupId = elevatorGroupId;
    this.elevatorId = elevatorId;
    this.requestedFloor = requestedFloor;
  }

  public int getRequestedFloor() {
    return requestedFloor;
  }

  @Override
  public ElevatorRequestMode getRequestMode() {
    return ElevatorRequestMode.INTERNAL;
  }

  public String getElevatorId() {
    return elevatorId;
  }

  @Override
  public String getElevatorGroupId() {
    return elevatorGroupId;
  }

  @Override
  public long getScheduledAt() {
    return scheduledAtMillis;
  }

  @Override
  public long getCompletedAt() {
    return completedAtMillis;
  }

  @Override
  public void setScheduledAt(final long scheduledAtMillis) {
    this.scheduledAtMillis = scheduledAtMillis;
  }

  @Override
  public void setCompletedAt(final long completedAtMillis) {
    this.completedAtMillis = completedAtMillis;
  }

  @Override
  public int compare(ElevatorInternalRequest requestOne, ElevatorInternalRequest requestTwo) {
    return Integer.valueOf(requestOne.getRequestedFloor())
        .compareTo(Integer.valueOf(requestTwo.getRequestedFloor()));
  }

}
