package me.yong_ju.example_project.domain.specification;

import java.time.LocalDateTime;
import me.yong_ju.example_project.domain.model.entity.Circle;

public class CircleRecommendSpecification {
  private final LocalDateTime executeDateTime;

  public CircleRecommendSpecification(LocalDateTime executeDateTime) {
    this.executeDateTime = executeDateTime;
  }

  public boolean isSatisfiedBy(Circle circle) {
    return 10 <= circle.countMembers() &&
        circle.getCreated().isBefore(executeDateTime.minusMonths(1));
  }
}
