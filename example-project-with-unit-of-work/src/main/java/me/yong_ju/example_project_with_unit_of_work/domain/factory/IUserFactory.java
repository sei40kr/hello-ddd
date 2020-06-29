package me.yong_ju.example_project_with_unit_of_work.domain.factory;

import me.yong_ju.example_project_with_unit_of_work.domain.entity.User;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.MailAddress;
import me.yong_ju.example_project_with_unit_of_work.domain.valueobject.UserName;

public interface IUserFactory {
  User create(UserName name, MailAddress mailAddress);
}
