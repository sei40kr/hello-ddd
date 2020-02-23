package me.yong_ju.hello_ddd.domain.factory;

import me.yong_ju.hello_ddd.domain.entity.User;
import me.yong_ju.hello_ddd.domain.valueobject.MailAddress;
import me.yong_ju.hello_ddd.domain.valueobject.UserName;

public interface IUserFactory {
  User create(UserName name, MailAddress mailAddress);
}
