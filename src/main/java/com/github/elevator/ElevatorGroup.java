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

}
