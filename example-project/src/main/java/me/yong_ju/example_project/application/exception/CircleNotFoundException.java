package me.yong_ju.example_project.application.exception;

import me.yong_ju.example_project.domain.model.valueobject.CircleId;

public class CircleNotFoundException extends Exception {
  private static final long serialVersionUID = 1L;

  public CircleNotFoundException(CircleId id, String message) {
    super(message);
  }
}
