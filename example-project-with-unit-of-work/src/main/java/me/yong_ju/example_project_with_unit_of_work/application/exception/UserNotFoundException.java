package me.yong_ju.example_project_with_unit_of_work.application.exception;

import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserId;

public class UserNotFoundException extends Exception {
  private static final long serialVersionUID = 5517963845033995984L;

  public UserNotFoundException(UserId userId) {
    super();
    // TODO implement this
  }
}
