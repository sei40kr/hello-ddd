package me.yong_ju.hello_ddd.domain.entity;

import java.util.Objects;
import me.yong_ju.hello_ddd.domain.valueobject.MailAddress;
import me.yong_ju.hello_ddd.domain.valueobject.UserId;
import me.yong_ju.hello_ddd.domain.valueobject.UserName;

public class User extends Entity {
  private final UserId id;
  private UserName name;
  private MailAddress mailAddress;

  public User(UserId id, UserName name, MailAddress mailAddress) {
    Objects.requireNonNull(id);
    Objects.requireNonNull(name);
    Objects.requireNonNull(mailAddress);

    this.id = id;
    this.name = name;
    this.mailAddress = mailAddress;
    markNew();
  }

  public UserId getId() { return id; }

  public UserName getName() { return name; }

  public MailAddress getMailAddress() { return mailAddress; }

  public void changeName(UserName newName) {
    Objects.requireNonNull(newName);

    this.name = newName;
    markDirty();
  }

  public void changeMailAddress(MailAddress newMailAddress) {
    Objects.requireNonNull(newMailAddress);

    this.mailAddress = newMailAddress;
    markDirty();
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
