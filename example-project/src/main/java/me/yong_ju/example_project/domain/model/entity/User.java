package me.yong_ju.example_project.domain.model.entity;

import me.yong_ju.example_project.domain.model.valueobject.UserId;

public class User {
  private final UserId id;

  public User(UserId id) { this.id = id; }

  public UserId getId() { return id; }
}
