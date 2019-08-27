package com.github.elevator;

import java.util.UUID;

/**
 * Base elevator request.
 * 
 * @author gaurav
 */
public interface ElevatorRequest {
  final String requestId = UUID.randomUUID().toString();
  final long createdAtMillis = System.currentTimeMillis();

  public default String getRequestId() {
    return requestId;
  }

  public ElevatorRequestMode getRequestMode();

  public String getElevatorGroupId();

  public default long getCreatedAt() {
    return createdAtMillis;
  }

  public long getScheduledAt();

  public long getCompletedAt();

  public void setScheduledAt(final long scheduledAtMillis);

  public void setCompletedAt(final long completedAtMillis);

}
