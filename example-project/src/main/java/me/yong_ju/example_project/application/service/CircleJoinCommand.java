package me.yong_ju.example_project.application.service;

import java.util.Objects;

public class CircleJoinCommand {
  private final String userId;
  private final String circleId;

  public CircleJoinCommand(String userId, String circleId) {
    Objects.requireNonNull(userId);
    Objects.requireNonNull(circleId);

    this.userId = userId;
    this.circleId = circleId;
  }

  public String getUserId() { return userId; }

  public String getCircleId() { return circleId; }
}
