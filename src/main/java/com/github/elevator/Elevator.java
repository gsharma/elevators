package com.github.elevator;

import java.util.Arrays;
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

  private final int lowestFloor;
  private final int highestFloor;
  private final int[] unscheduledFloors;

  private ElevatorDirection direction = ElevatorDirection.NONE;
  private ElevatorOperationMode mode = ElevatorOperationMode.STOPPED;
  private int currentFloor = Integer.MIN_VALUE;
  private int nextFloor = Integer.MIN_VALUE;

  public Elevator(final int maxUserCapacity, final int lowestFloor, final int highestFloor,
      final int[] unscheduledFloors) {
    this.maxUserCapacity = maxUserCapacity;
    this.lowestFloor = lowestFloor;
    this.highestFloor = highestFloor;
    this.unscheduledFloors = unscheduledFloors;
    if (lowestFloor > highestFloor) {
      throw new IllegalArgumentException("lowestFloor cannot be greater than the highestFloor");
    }
  }

  public void reset() {
    direction = ElevatorDirection.NONE;
    mode = ElevatorOperationMode.STOPPED;
    currentFloor = Integer.MIN_VALUE;
    nextFloor = Integer.MIN_VALUE;
  }

  public String getId() {
    return id;
  }

  public int getMaxUserCapacity() {
    return maxUserCapacity;
  }

  public int getLowestFloor() {
    return lowestFloor;
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

  public int getNextFloor() {
    return nextFloor;
  }

  public void setNextFloor(final int nextFloor) {
    this.nextFloor = nextFloor;
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Elevator [id=").append(id).append(", groupId=").append(groupId)
        .append(", maxUserCapacity=").append(maxUserCapacity).append(", lowestFloor=")
        .append(lowestFloor).append(", highestFloor=").append(highestFloor)
        .append(", unscheduledFloors=").append(Arrays.toString(unscheduledFloors))
        .append(", direction=").append(direction).append(", mode=").append(mode)
        .append(", currentFloor=").append(currentFloor).append(", nextFloor=").append(nextFloor)
        .append("]");
    return builder.toString();
  }

}
