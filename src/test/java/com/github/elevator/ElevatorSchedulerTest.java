package com.github.elevator;

import org.junit.Test;

/**
 * Functional sanity tests for the ElevatorScheduler
 * 
 * @author gaurav
 */
public final class ElevatorSchedulerTest {

  @Test
  public void testScheduler() {
    final ElevatorGroup group = new ElevatorGroup();

    final Elevator one = new Elevator(10, 50, null);
    group.addElevator(one);
    final Elevator two = new Elevator(10, 50, null);
    group.addElevator(two);
    final Elevator three = new Elevator(10, 50, null);
    group.addElevator(three);
    final Elevator four = new Elevator(10, 50, null);
    group.addElevator(four);
    final Elevator five = new Elevator(10, 50, null);
    group.addElevator(five);

    final ElevatorScheduler scheduler = new ElevatorScheduler(group);
    scheduler.init();
    scheduler.tini();
  }

}
