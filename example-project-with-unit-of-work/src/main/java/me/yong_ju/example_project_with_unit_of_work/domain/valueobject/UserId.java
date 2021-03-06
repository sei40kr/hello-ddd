package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

import java.util.Objects;

public class UserId {
  private final String value;

  public UserId(String value) {
    Objects.requireNonNull(value);

    this.value = value;
  }

  public String getValue() { return value; }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }

    UserId anUserId = (UserId)object;
    if (value == null && anUserId.value != null) {
      return false;
    } else if (!value.equals(anUserId.value)) {
      return false;
    }
    return true;
  }
}
