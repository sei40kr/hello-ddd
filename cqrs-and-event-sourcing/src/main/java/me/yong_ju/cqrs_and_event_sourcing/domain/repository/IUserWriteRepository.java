package me.yong_ju.cqrs_and_event_sourcing.domain.repository;

import me.yong_ju.cqrs_and_event_sourcing.domain.model.User;

public interface IUserWriteRepository {
  User getUser(String userId);

  void addUser(String userId, User user);
}
