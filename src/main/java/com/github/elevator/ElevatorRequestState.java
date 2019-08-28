package com.github.elevator;

/**
 * Enum representing the state of an ElevatorRequest.
 * 
 * @author gaurav
 */
public enum ElevatorRequestState {
  INIT, PENDING_SCHEDULING, SCHEDULED, COMPLETED, FAILED;
}
