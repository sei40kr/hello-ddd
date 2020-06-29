package me.yong_ju.example_project_with_unit_of_work.domain.factory;

import me.yong_ju.example_project_with_unit_of_work.domain.entity.User;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.MailAddress;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserId;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserName;

public class InMemoryUserFactory implements IUserFactory {
  private Integer currentId = 0;

  @Override
  public User create(UserName anUserName, MailAddress aMailAddress) {
    currentId++;

    return new User(new UserId(currentId.toString()), anUserName, aMailAddress);
  }
}
