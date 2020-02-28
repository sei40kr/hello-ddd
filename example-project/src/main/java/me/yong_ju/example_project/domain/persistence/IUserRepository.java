package me.yong_ju.example_project.domain.persistence;

import java.util.Optional;

import me.yong_ju.example_project.domain.model.entity.User;
import me.yong_ju.example_project.domain.model.valueobject.UserId;

public interface IUserRepository {
    Optional<User> find(UserId userId);
}
