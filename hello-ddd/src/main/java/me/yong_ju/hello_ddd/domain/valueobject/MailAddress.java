package me.yong_ju.hello_ddd.domain.valueobject;

import java.util.Objects;

public class MailAddress {
  private final String value;

  public MailAddress(String value) {
    Objects.requireNonNull(value);

    this.value = value;
  }

  public String getValue() { return value; }
}
