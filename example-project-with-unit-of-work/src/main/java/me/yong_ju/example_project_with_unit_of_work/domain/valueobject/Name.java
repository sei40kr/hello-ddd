package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

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
