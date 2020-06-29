package me.yong_ju.example_project_with_unit_of_work.domain.valueobject;

import java.util.Objects;

public class FullName {
  private final Name firstName;
  private final Name lastName;

  public FullName(Name firstName, Name lastName) {
    Objects.requireNonNull(firstName);
    Objects.requireNonNull(lastName);

    this.firstName = firstName;
    this.lastName = lastName;
  }
}
