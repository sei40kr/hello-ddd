package me.yong_ju.example_project.application.exception;

import me.yong_ju.example_project.domain.model.valueobject.CircleId;

public class CircleFullException extends Exception {
  private static final long serialVersionUID = 254676384652547165L;

  public CircleFullException(CircleId id) { super(); }
}
