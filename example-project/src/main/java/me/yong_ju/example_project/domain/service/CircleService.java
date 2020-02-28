package me.yong_ju.example_project.domain.service;

import me.yong_ju.example_project.domain.model.entity.Circle;
import me.yong_ju.example_project.domain.persistence.ICircleRepository;

public class CircleService {
  private final ICircleRepository circleRepository;

  public CircleService(ICircleRepository circleRepository) {
    this.circleRepository = circleRepository;
  }

  public boolean exists(Circle circle) {
    return !circleRepository.find(circle.getName()).isEmpty();
  }
}
