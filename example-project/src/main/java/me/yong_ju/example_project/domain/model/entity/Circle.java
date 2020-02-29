package me.yong_ju.example_project.domain.model.entity;

import java.util.List;
import java.util.Objects;
import me.yong_ju.example_project.application.exception.CircleFullException;
import me.yong_ju.example_project.domain.model.valueobject.CircleId;
import me.yong_ju.example_project.domain.model.valueobject.CircleName;
import me.yong_ju.example_project.domain.model.valueobject.UserId;

public class Circle {
  private final CircleId id;
  private CircleName name;
  private User owner;
  // private List<User> members;
  private List<UserId> members;

  public Circle(CircleId id, CircleName name, User owner,
                List<UserId> members) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(name);
    Objects.requireNonNull(owner);
    Objects.requireNonNull(members);

    this.id = id;
    this.name = name;
    this.owner = owner;
    this.members = members;
  }

  public CircleId getId() { return id; }

  public CircleName getName() { return name; }

  public User getOwner() { return owner; }

  /**
   * サークルのオーナーを含めて 30 名か確認
   */
  public boolean isFull() { return members.size() >= 29; }

  public void join(UserId memberId) throws CircleFullException {
    Objects.requireNonNull(memberId);

    if (isFull()) {
      throw new CircleFullException(id);
    }

    members.add(memberId);
  }
}
