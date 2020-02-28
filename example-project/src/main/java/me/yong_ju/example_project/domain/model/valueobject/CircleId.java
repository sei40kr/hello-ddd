package me.yong_ju.example_project.domain.model.valueobject;

import java.util.Objects;

public class CircleId {
  private final String value;

  public CircleId(String value) {
    Objects.requireNonNull(value);

    this.value = value;
  }

  public String getValue() { return value; }
}
