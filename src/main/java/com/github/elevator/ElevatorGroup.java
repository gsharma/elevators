package com.github.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This object represents a group of Elevator objects.
 * 
 * @author gaurav
 */
public final class ElevatorGroup {
  private final String id = UUID.randomUUID().toString();
  private final List<Elevator> elevators = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void addElevator(final Elevator elevator) {
    elevator.setGroupId(id);
    this.elevators.add(elevator);
  }

  public List<Elevator> getElevators() {
    return elevators;
  }

  public Elevator findElevator(final String elevatorId) {
    Elevator found = null;
    for (final Elevator elevator : elevators) {
      if (elevator.getId().equals(elevatorId)) {
        found = elevator;
        break;
      }
    }
    return found;
  }

  public List<Elevator> findNormalModeElevators() {
    final List<Elevator> normalModeElevators = new ArrayList<>();
    for (final Elevator elevator : elevators) {
      if (elevator.getMode() == ElevatorOperationMode.NORMAL) {
        normalModeElevators.add(elevator);
      }
    }
    return normalModeElevators;
  }

  public void reset() {
    for (final Elevator elevator : elevators) {
      elevator.reset();
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ElevatorGroup [id=").append(id).append(", elevators=").append(elevators)
        .append("]");
    return builder.toString();
  }

}
