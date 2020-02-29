package me.yong_ju.example_project.domain.specification;

import me.yong_ju.example_project.domain.model.entity.Circle;
import me.yong_ju.example_project.domain.model.entity.User;
import me.yong_ju.example_project.domain.persistence.IUserRepository;

public class CircleFullSpecification {
  private final IUserRepository userRepository;

  public CircleFullSpecification(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean isSatisfiedBy(Circle circle) {
    var users = userRepository.find(circle.getMembers());
    var premiumUserNumber = users.stream().filter(User::isPremium).count();
    var circleUpperLimit = premiumUserNumber < 10 ? 30 : 50;
    return circle.countMembers() >= circleUpperLimit;
  }
}
