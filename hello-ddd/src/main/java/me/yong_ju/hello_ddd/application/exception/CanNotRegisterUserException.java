package me.yong_ju.hello_ddd.application.exception;

import me.yong_ju.hello_ddd.domain.entity.User;

public class CanNotRegisterUserException extends Exception {
  public CanNotRegisterUserException(User anUser, String message) {
    super(message);
    // TODO implement this
  }
}
