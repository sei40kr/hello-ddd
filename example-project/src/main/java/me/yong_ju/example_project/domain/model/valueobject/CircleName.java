package me.yong_ju.example_project.domain.model.valueobject;

import java.util.Objects;

public class CircleName {
  private String value;

  public CircleName(String value) {
    Objects.requireNonNull(value);
    if (value.length() < 3) {
      throw new IllegalArgumentException("サークル名は 3 文字以上です。");
    }
    if (20 < value.length()) {
      throw new IllegalArgumentException("サークル名は 20 文字以下です。");
    }

    this.value = value;
  }

  public String getValue() { return value; }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CircleName other = (CircleName)obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}
