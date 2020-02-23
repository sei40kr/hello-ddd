package me.yong_ju.hello_ddd.domain.factory;

import me.yong_ju.hello_ddd.domain.entity.User;
import me.yong_ju.hello_ddd.domain.valueobject.MailAddress;
import me.yong_ju.hello_ddd.domain.valueobject.UserId;
import me.yong_ju.hello_ddd.domain.valueobject.UserName;

public class InMemoryUserFactory implements IUserFactory {
  private Integer currentId = 0;

  @Override
  public User create(UserName anUserName, MailAddress aMailAddress) {
    currentId++;

    return new User(new UserId(currentId.toString()), anUserName, aMailAddress);
  }
}
