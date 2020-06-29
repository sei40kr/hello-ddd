package me.yong_ju.example_project_with_unit_of_work.domain.repository;

import java.util.Optional;

import me.yong_ju.example_project_with_unit_of_work.domain.entity.User;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserId;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserName;

public interface IUserRepository {
  Optional<User> find(UserId anUserId);
  Optional<User> find(UserName anUserName);

  void save(User anUser);
}
