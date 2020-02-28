package me.yong_ju.example_project.domain.model.valueobject;

import java.util.Objects;

public class UserName {
  private final String value;

  public UserName(String value) {
    Objects.requireNonNull(value);

    this.value = value;
  }

  public String getValue() { return value; }
}
