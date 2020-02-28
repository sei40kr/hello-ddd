package me.yong_ju.example_project.application.service;

import java.util.Objects;

public class CircleInviteCommand {
  private final String fromUserId;
  private final String invitedUserId;
  private final String circleId;

  public CircleInviteCommand(String fromUserId, String invitedUserId,
                             String circleId) {
    Objects.requireNonNull(fromUserId);
    Objects.requireNonNull(invitedUserId);
    Objects.requireNonNull(circleId);

    this.fromUserId = fromUserId;
    this.invitedUserId = invitedUserId;
    this.circleId = circleId;
  }

  public String getFromUserId() { return fromUserId; }

  public String getInvitedUserId() { return invitedUserId; }

  public String getCircleId() { return circleId; }
}
