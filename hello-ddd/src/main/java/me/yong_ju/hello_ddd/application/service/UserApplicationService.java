package me.yong_ju.hello_ddd.application.service;

import java.util.Optional;
import java.util.UUID;
import me.yong_ju.hello_ddd.application.command.UserUpdateCommand;
import me.yong_ju.hello_ddd.application.dto.UserData;
import me.yong_ju.hello_ddd.application.exception.CanNotRegisterUserException;
import me.yong_ju.hello_ddd.application.exception.UserNotFoundException;
import me.yong_ju.hello_ddd.domain.entity.User;
import me.yong_ju.hello_ddd.domain.factory.IUserFactory;
import me.yong_ju.hello_ddd.domain.repository.IUserRepository;
import me.yong_ju.hello_ddd.domain.service.UserService;
import me.yong_ju.hello_ddd.domain.valueobject.MailAddress;
import me.yong_ju.hello_ddd.domain.valueobject.UserId;
import me.yong_ju.hello_ddd.domain.valueobject.UserName;

public class UserApplicationService {
  private IUserFactory userFactory;
  private IUserRepository userRepository;
  private UserService userService;

  public UserApplicationService(IUserFactory userFactory,
                                IUserRepository userRepository,
                                UserService userService) {
    this.userFactory = userFactory;
    this.userRepository = userRepository;
    this.userService = userService;
  }

  public void register(String userName, String mailAddress)
      throws CanNotRegisterUserException {
    User anUser = userFactory.create(new UserName(userName),
                                     new MailAddress(mailAddress));

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

  public void update(UserUpdateCommand command)
      throws UserNotFoundException, CanNotRegisterUserException {
    var targetId = new UserId(command.getId());
    var anUser = userRepository.find(targetId).orElseThrow(
        () -> new UserNotFoundException(targetId));

    var name = command.getName();
    if (name != null) {
      var newUserName = new UserName(name);
      anUser.changeName(newUserName);
      if (userService.exists(anUser)) {
        throw new CanNotRegisterUserException(anUser,
                                              "ユーザは既に存在しています。");
      }
    }

    var mailAddress = command.getMailAddress();
    if (mailAddress != null) {
      var newMailAddress = new MailAddress(mailAddress);
      anUser.changeMailAddress(newMailAddress);
    }
  }
}
