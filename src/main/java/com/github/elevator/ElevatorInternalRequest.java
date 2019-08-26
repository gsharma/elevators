package com.github.elevator;

/**
 * Elevator scheduling request made from within the elevator.
 * 
 * @author gaurav
 */
public final class ElevatorInternalRequest implements ElevatorRequest {
  private final String elevatorGroupId;
  private final String elevatorId;
  private final int requestedFloor;

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

}
