package me.yong_ju.hello_ddd.domain.valueobject;

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
}
