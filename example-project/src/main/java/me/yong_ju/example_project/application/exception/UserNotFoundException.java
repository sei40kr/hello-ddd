package me.yong_ju.example_project.application.exception;

import me.yong_ju.example_project.domain.model.valueobject.UserId;

public class UserNotFoundException extends Exception {
  private static final long serialVersionUID = 8679699961945956173L;

  public UserNotFoundException(UserId ownerId, String message) {
    super(message);
  }
}
