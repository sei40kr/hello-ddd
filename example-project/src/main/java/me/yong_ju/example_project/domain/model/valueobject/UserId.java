package me.yong_ju.example_project.domain.model.valueobject;

import java.util.Objects;

public class UserId {
  private final String value;

  public UserId(String value) {
    Objects.requireNonNull(value);

    this.value = value;
  }

  public String getValue() { return value; }
}
