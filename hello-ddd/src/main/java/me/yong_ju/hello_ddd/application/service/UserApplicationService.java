package me.yong_ju.hello_ddd.application.service;

import java.util.Optional;
import java.util.UUID;

import me.yong_ju.hello_ddd.application.dto.UserData;
import me.yong_ju.hello_ddd.application.exception.CanNotRegisterUserException;
import me.yong_ju.hello_ddd.domain.entity.User;
import me.yong_ju.hello_ddd.domain.repository.IUserRepository;
import me.yong_ju.hello_ddd.domain.service.UserService;
import me.yong_ju.hello_ddd.domain.valueobject.MailAddress;
import me.yong_ju.hello_ddd.domain.valueobject.UserId;
import me.yong_ju.hello_ddd.domain.valueobject.UserName;

public class UserApplicationService {
  private IUserRepository userRepository;
  private UserService userService;

  public UserApplicationService(IUserRepository userRepository,
                                UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  public void register(String userName, String mailAddress)
      throws CanNotRegisterUserException {
    User anUser =
        new User(new UserId(UUID.randomUUID().toString()),
                 new UserName(userName), new MailAddress(mailAddress));

    if (userService.exists(anUser)) {
      throw new CanNotRegisterUserException(anUser,
                                            "ユーザーは既に存在しています。");
    }

    userRepository.save(anUser);
  }

  public Optional<UserData> get(String userId) {
    return userRepository.find(new UserId(userId))
        .map(anUser
             -> new UserData(anUser.getId().getValue(),
                             anUser.getName().getValue(),
                             anUser.getMailAddress().getValue()));
  }
}
