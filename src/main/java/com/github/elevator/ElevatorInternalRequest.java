package com.github.elevator;

import java.util.UUID;

/**
 * Elevator scheduling request made from within the elevator.
 * 
 * ElevatorInternalRequest has a Comparator used for ordering by requestedFloor.
 * 
 * @author gaurav
 */
public final class ElevatorInternalRequest
    implements ElevatorRequest, Comparable<ElevatorInternalRequest> {
  private final String requestId = UUID.randomUUID().toString();
  private final String elevatorGroupId;
  private final String elevatorId;
  private final int requestedFloor;

  private long scheduledAtMillis;
  private long completedAtMillis;
  private ElevatorRequestState requestState;

  public ElevatorInternalRequest(final String elevatorGroupId, final String elevatorId,
      final int requestedFloor) {
    requestState = ElevatorRequestState.INIT;
    this.elevatorGroupId = elevatorGroupId;
    this.elevatorId = elevatorId;
    this.requestedFloor = requestedFloor;
  }

  public int getRequestedFloor() {
    return requestedFloor;
  }

  @Override
  public String getRequestId() {
    return requestId;
  }

  @Override
  public ElevatorRequestLocation getRequestLocation() {
    return ElevatorRequestLocation.INTERNAL;
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
  public int compareTo(ElevatorInternalRequest other) {
    return Integer.valueOf(getRequestedFloor())
        .compareTo(Integer.valueOf(other.getRequestedFloor()));
  }

  @Override
  public ElevatorRequestState getRequestState() {
    return requestState;
  }

  @Override
  public void setRequestState(final ElevatorRequestState requestState) {
    this.requestState = requestState;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ElevatorInternalRequest [requestId=").append(requestId)
        .append(", elevatorGroupId=").append(elevatorGroupId).append(", elevatorId=")
        .append(elevatorId).append(", requestedFloor=").append(requestedFloor)
        .append(", requestState=").append(requestState).append(", createdAt=")
        .append(createdAtMillis).append(", scheduledAtMillis=").append(scheduledAtMillis)
        .append(", completedAtMillis=").append(completedAtMillis).append("]");
    return builder.toString();
  }

}
