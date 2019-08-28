package com.github.elevator;

/**
 * Base elevator request.
 * 
 * @author gaurav
 */
public interface ElevatorRequest {
  final long createdAtMillis = System.currentTimeMillis();

  public String getRequestId();

  public ElevatorRequestMode getRequestMode();

  public ElevatorRequestState getRequestState();

  public void setRequestState(final ElevatorRequestState requestState);

  public String getElevatorGroupId();

  public default long getCreatedAt() {
    return createdAtMillis;
  }

  public long getScheduledAt();

  public long getCompletedAt();

  public void setScheduledAt(final long scheduledAtMillis);

  public void setCompletedAt(final long completedAtMillis);

}
