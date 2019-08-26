package com.github.elevator;

/**
 * Core object representing the elevator scheduler.
 * 
 * @author gaurav
 */
public final class ElevatorScheduler {
  private final ElevatorGroup elevatorGroup;

  public ElevatorScheduler(final ElevatorGroup elevatorGroup) {
    this.elevatorGroup = elevatorGroup;
  }

  public void scheduleRequest(final ElevatorRequest request) {}

}
