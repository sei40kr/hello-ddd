package me.yong_ju.example_project.application.service;

import java.util.Objects;

public class CircleCreateCommand {
  private final String userId;
  private final String name;

  public CircleCreateCommand(String userId, String name) {
    Objects.requireNonNull(userId);
    Objects.requireNonNull(name);

    this.userId = userId;
    this.name = name;
  }

  public String getUserId() { return userId; }

  public String getName() { return name; }
}
