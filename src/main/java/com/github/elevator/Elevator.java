package com.github.elevator;

import java.util.UUID;

/**
 * Base object representing elevator metadata.
 * 
 * @author gaurav
 */
public final class Elevator {
  private final String id = UUID.randomUUID().toString();
  private String groupId;

  private ElevatorDirection direction = ElevatorDirection.NONE;
  private int currentFloor;

  public String getId() {
    return id;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(final String groupId) {
    this.groupId = groupId;
  }

  public ElevatorDirection getDirection() {
    return direction;
  }

  public void setDirection(final ElevatorDirection direction) {
    this.direction = direction;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(final int currentFloor) {
    this.currentFloor = currentFloor;
  }

}
