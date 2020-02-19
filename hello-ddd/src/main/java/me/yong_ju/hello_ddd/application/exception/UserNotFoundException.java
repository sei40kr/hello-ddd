package me.yong_ju.hello_ddd.application.exception;

import me.yong_ju.hello_ddd.domain.valueobject.UserId;

public class UserNotFoundException extends Exception {
  private static final long serialVersionUID = 5517963845033995984L;

  public UserNotFoundException(UserId userId) {
    super();
    // TODO implement this
  }
}
