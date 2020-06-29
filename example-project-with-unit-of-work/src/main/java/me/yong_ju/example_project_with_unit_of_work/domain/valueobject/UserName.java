package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

import java.util.Objects;

public class UserName {
  private final String value;

  public UserName(String value) {
    Objects.requireNonNull(value);

    if (value.length() < 3) {
      throw new IllegalArgumentException("ユーザー名は3文字以上です。");
    }

    this.value = value;
  }

  public String getValue() { return value; }
}
