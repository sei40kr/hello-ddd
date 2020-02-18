package me.yong_ju.hello_ddd.domain.valueobject;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
  private final String value;

  public Name(String value) {
    Objects.requireNonNull(value);

    if (!Pattern.matches("^[a-zA-Z]+$", value)) {
      throw new IllegalArgumentException(
          "許可されていない文字が使われています。");
    }

    this.value = value;
  }
}
