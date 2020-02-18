package me.yong_ju.hello_ddd.domain.entity;

import java.util.Objects;
import me.yong_ju.hello_ddd.domain.valueobject.UserId;

public class User {
  private final UserId id;
  private final String name;

  public User(UserId id, String name) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(name);

    if (name.length() < 3) {
      throw new IllegalArgumentException("ユーザー名は3文字以上です。");
    }

    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (getClass() != object.getClass()) {
      return false;
    }

    User anUser = (User)object;
    return this.id.equals(anUser.id);
  }
}
