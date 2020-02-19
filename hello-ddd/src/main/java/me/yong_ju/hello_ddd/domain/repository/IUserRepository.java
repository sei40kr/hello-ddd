package me.yong_ju.hello_ddd.domain.repository;

import java.util.Optional;

import me.yong_ju.hello_ddd.domain.entity.User;
import me.yong_ju.hello_ddd.domain.valueobject.UserName;

public interface IUserRepository {
  Optional<User> find(UserName anUserName);

  void save(User anUser);
}
