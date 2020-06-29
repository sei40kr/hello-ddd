package me.yong_ju.example_project_with_unit_of_work.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import me.yong_ju.example_project_with_unit_of_work.domain.entity.User;
import me.yong_ju.example_project_with_unit_of_work.domain.repository.IUserRepository;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserId;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserName;

public class InMemoryUserRepository implements IUserRepository {
  private Map<UserId, User> store = new HashMap<>();

  @Override
  public Optional<User> find(UserId anUserId) {
    return Optional.ofNullable(store.get(anUserId));
  }

  @Override
  public Optional<User> find(final UserName anUserName) {
    return store.entrySet()
        .stream()
        .map(entry -> entry.getValue())
        .filter(anUser -> anUser.getName().equals(anUserName))
        .findFirst()
        .map(anUser -> cloneUser(anUser));
  }

  @Override
  public void save(User anUser) {
    store.put(anUser.getId(), cloneUser(anUser));
  }

  private User cloneUser(User anUser) {
    return new User(anUser.getId(), anUser.getName(), anUser.getMailAddress());
  }
}
