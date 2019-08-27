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

  // for simplicity, assume users have uniform weight and elevator capacity can be expressed as the
  // maximum users that can be packed in an elevator
  private final int maxUserCapacity;

  private final int highestFloor;
  private final int[] unscheduledFloors;

  private ElevatorDirection direction = ElevatorDirection.NONE;
  private ElevatorOperationMode mode = ElevatorOperationMode.STOPPED;
  private int currentFloor;

  public Elevator(final int maxUserCapacity, final int highestFloor,
      final int[] unscheduledFloors) {
    this.maxUserCapacity = maxUserCapacity;
    this.highestFloor = highestFloor;
    this.unscheduledFloors = unscheduledFloors;
  }

  public String getId() {
    return id;
  }

  public int getMaxUserCapacity() {
    return maxUserCapacity;
  }

  public int getHighestFloor() {
    return highestFloor;
  }

  public int[] getUnscheduledFloors() {
    return unscheduledFloors;
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

  public ElevatorOperationMode getMode() {
    return mode;
  }

  public void setMode(final ElevatorOperationMode mode) {
    this.mode = mode;
  }

  public int getCurrentFloor() {
    return currentFloor;
  }

  public void setCurrentFloor(final int currentFloor) {
    this.currentFloor = currentFloor;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Elevator)) {
      return false;
    }
    Elevator other = (Elevator) obj;
    if (groupId == null) {
      if (other.groupId != null) {
        return false;
      }
    } else if (!groupId.equals(other.groupId)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

}
