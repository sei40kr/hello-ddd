package me.yong_ju.example_project.domain.model.entity;

import me.yong_ju.example_project.domain.model.valueobject.UserId;

public class User {
  private final UserId id;
  private final boolean premium;

  public User(UserId id, boolean premium) {
    this.id = id;
    this.premium = premium;
  }

  public UserId getId() { return id; }

  public boolean isPremium() { return premium; }
}
