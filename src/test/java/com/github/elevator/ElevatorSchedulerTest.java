package com.github.elevator;

import static org.junit.Assert.assertEquals;

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
    assertEquals(0, one.getCurrentFloor());
    assertEquals(0, one.getNextFloor());
    assertEquals(ElevatorDirection.NONE, one.getDirection());
    group.addElevator(one);

    final Elevator two = new Elevator(10, 50, null);
    assertEquals(0, two.getCurrentFloor());
    assertEquals(0, two.getNextFloor());
    assertEquals(ElevatorDirection.NONE, two.getDirection());
    group.addElevator(two);

    final Elevator three = new Elevator(10, 50, null);
    assertEquals(0, three.getCurrentFloor());
    assertEquals(0, three.getNextFloor());
    assertEquals(ElevatorDirection.NONE, three.getDirection());
    group.addElevator(three);

    final Elevator four = new Elevator(10, 50, null);
    assertEquals(0, four.getCurrentFloor());
    assertEquals(0, four.getNextFloor());
    assertEquals(ElevatorDirection.NONE, four.getDirection());
    group.addElevator(four);

    final Elevator five = new Elevator(10, 50, null);
    assertEquals(0, five.getCurrentFloor());
    assertEquals(0, five.getNextFloor());
    assertEquals(ElevatorDirection.NONE, five.getDirection());
    group.addElevator(five);

    final ElevatorScheduler scheduler = new ElevatorScheduler(group);
    scheduler.init();
    scheduler.tini();
  }

}
