package me.yong_ju.example_project.application.exception;

import me.yong_ju.example_project.domain.model.entity.Circle;

public class CanNotRegisterCircleException extends Exception {
  private static final long serialVersionUID = 1L;

  public CanNotRegisterCircleException(Circle circle, String message) {
    super(message);
  }
}
