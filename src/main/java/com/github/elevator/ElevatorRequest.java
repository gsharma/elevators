package com.github.elevator;

import java.util.UUID;

/**
 * Base elevator request.
 * 
 * @author gaurav
 */
public interface ElevatorRequest {
  final String requestId = UUID.randomUUID().toString();
  final long createdMillis = System.currentTimeMillis();

  public default String getRequestId() {
    return requestId;
  }

  public ElevatorRequestMode getRequestMode();

  public String getElevatorGroupId();

}
