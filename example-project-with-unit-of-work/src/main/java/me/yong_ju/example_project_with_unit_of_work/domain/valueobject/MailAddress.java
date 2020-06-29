package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

import java.util.Objects;

public class MailAddress {
  private final String value;

  public MailAddress(String value) {
    Objects.requireNonNull(value);

    this.value = value;
  }

  public String getValue() { return value; }
}
