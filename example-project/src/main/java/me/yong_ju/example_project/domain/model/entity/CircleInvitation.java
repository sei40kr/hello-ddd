package me.yong_ju.example_project.domain.model.entity;

import java.util.Objects;

public class CircleInvitation {
  private Circle circle;
  private User fromUser;
  private User invitedUser;

  public CircleInvitation(Circle circle, User fromUser, User invitedUser) {
    Objects.requireNonNull(circle);
    Objects.requireNonNull(fromUser);
    Objects.requireNonNull(invitedUser);

    this.circle = circle;
    this.fromUser = fromUser;
    this.invitedUser = invitedUser;
  }
}
