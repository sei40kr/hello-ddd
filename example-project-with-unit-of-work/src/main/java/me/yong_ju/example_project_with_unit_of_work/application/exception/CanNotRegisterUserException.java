package me.yong_ju.example_project_with_unit_of_work.application.exception;

import me.yong_ju.example_project_with_unit_of_work.domain.entity.User;

public class CanNotRegisterUserException extends Exception {
  public CanNotRegisterUserException(User anUser, String message) {
    super(message);
    // TODO implement this
  }
}
