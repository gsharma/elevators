package com.github.elevator;

/**
 * Elevator scheduling request made from outside the elevator.
 * 
 * @author gaurav
 */
public final class ElevatorExternalRequest implements ElevatorRequest {
  private final String elevatorGroupId;
  private final int requestedFromFloor;
  private final ElevatorRequestDirection direction;

  private long scheduledAtMillis;
  private long completedAtMillis;

  public ElevatorExternalRequest(final String elevatorGroupId, final int requestedFromFloor,
      final ElevatorRequestDirection direction) {
    this.elevatorGroupId = elevatorGroupId;
    this.requestedFromFloor = requestedFromFloor;
    this.direction = direction;
  }

  @Override
  public ElevatorRequestMode getRequestMode() {
    return ElevatorRequestMode.EXTERNAL;
  }

  public int getRequestedFromFloor() {
    return requestedFromFloor;
  }

  public ElevatorRequestDirection getDirection() {
    return direction;
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

}
