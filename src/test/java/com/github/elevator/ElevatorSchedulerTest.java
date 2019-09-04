package com.github.elevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    assertNotNull(group.getId());

    final Elevator one = new Elevator(10, 1, 50, null);
    group.addElevator(one);

    final Elevator two = new Elevator(10, 1, 50, null);
    group.addElevator(two);

    final Elevator three = new Elevator(10, 1, 50, null);
    group.addElevator(three);

    final Elevator four = new Elevator(10, 1, 50, null);
    group.addElevator(four);

    final Elevator five = new Elevator(10, 1, 50, null);
    group.addElevator(five);

    assertEquals(5, group.getElevators().size());

    for (final Elevator elevator : group.getElevators()) {
      assertNotNull(elevator.getId());
      assertEquals(Integer.MIN_VALUE, elevator.getCurrentFloor());
      assertEquals(Integer.MIN_VALUE, elevator.getNextFloor());
      assertEquals(ElevatorOperationMode.STOPPED, elevator.getMode());
      assertEquals(ElevatorDirection.NONE, elevator.getDirection());
    }

    final ElevatorScheduler scheduler = new ElevatorScheduler(group);
    scheduler.init();

    final ElevatorExternalRequest externalOne =
        new ElevatorExternalRequest(group.getId(), 1, ElevatorRequestDirection.UP);
    assertNotNull(externalOne.getRequestId());
    assertTrue(externalOne.getCreatedAt() > 0);
    assertEquals(ElevatorRequestState.INIT, externalOne.getRequestState());

    scheduler.scheduleRequest(externalOne);
    assertEquals(ElevatorRequestState.PENDING_SCHEDULING, externalOne.getRequestState());

    scheduler.tini();
  }

}
