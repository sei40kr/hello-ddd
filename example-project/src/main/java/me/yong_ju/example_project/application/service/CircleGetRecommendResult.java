package me.yong_ju.example_project.application.service;

import java.util.List;
import me.yong_ju.example_project.domain.model.entity.Circle;

public class CircleGetRecommendResult {
  private final List<Circle> circles;

  public CircleGetRecommendResult(final List<Circle> circles) {
    this.circles = circles;
  }

  public List<Circle> getCircles() { return circles; }
}
