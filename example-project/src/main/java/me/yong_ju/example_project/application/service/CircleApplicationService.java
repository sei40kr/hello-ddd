package me.yong_ju.example_project.application.service;

import me.yong_ju.example_project.application.exception.CanNotRegisterCircleException;
import me.yong_ju.example_project.application.exception.CircleFullException;
import me.yong_ju.example_project.application.exception.CircleNotFoundException;
import me.yong_ju.example_project.application.exception.UserNotFoundException;
import me.yong_ju.example_project.domain.factory.ICircleFactory;
import me.yong_ju.example_project.domain.model.entity.CircleInvitation;
import me.yong_ju.example_project.domain.model.valueobject.CircleId;
import me.yong_ju.example_project.domain.model.valueobject.CircleName;
import me.yong_ju.example_project.domain.model.valueobject.UserId;
import me.yong_ju.example_project.domain.persistence.ICircleInvitationRepository;
import me.yong_ju.example_project.domain.persistence.ICircleRepository;
import me.yong_ju.example_project.domain.persistence.IUserRepository;
import me.yong_ju.example_project.domain.service.CircleService;

public class CircleApplicationService {
  private final ICircleFactory circleFactory;
  private final ICircleRepository circleRepository;
  private final ICircleInvitationRepository circleInvitationRepository;
  private final CircleService circleService;
  private final IUserRepository userRepository;

  public CircleApplicationService(
      ICircleFactory circleFactory, ICircleRepository circleRepository,
      ICircleInvitationRepository circleInvitationRepository,
      CircleService circleService, IUserRepository userRepository) {
    this.circleFactory = circleFactory;
    this.circleRepository = circleRepository;
    this.circleInvitationRepository = circleInvitationRepository;
    this.circleService = circleService;
    this.userRepository = userRepository;
  }

  public void create(CircleCreateCommand command)
      throws UserNotFoundException, CanNotRegisterCircleException {
    var ownerId = new UserId(command.getUserId());
    var owner = userRepository.find(ownerId).orElseThrow(
        ()
            -> new UserNotFoundException(
                ownerId,
                "サークルのオーナーとなるユーザが見つかりませんでした。"));

    var name = new CircleName(command.getName());
    var circle = circleFactory.create(name, owner);
    if (circleService.exists(circle)) {
      throw new CanNotRegisterCircleException(circle,
                                              "サークルは既に存在しています。");
    }

    circleRepository.save(circle);
  }

  public void join(CircleJoinCommand command) throws UserNotFoundException,
                                                     CircleNotFoundException,
                                                     CircleFullException {
    var memberId = new UserId(command.getUserId());
    var member = userRepository.find(memberId).orElseThrow(
        ()
            -> new UserNotFoundException(memberId,
                                         "ユーザが見つかりませんでした。"));

    var id = new CircleId(command.getCircleId());
    var circle = circleRepository.find(id).orElseThrow(
        ()
            -> new CircleNotFoundException(id,
                                           "サークルが見つかりませんでした。"));

    circle.join(member.getId());

    circleRepository.save(circle);
  }

  public void invite(CircleInviteCommand command)
      throws UserNotFoundException, CircleNotFoundException,
             CircleFullException {
    var fromUserId = new UserId(command.getFromUserId());
    var fromUser =
        userRepository.find(fromUserId)
            .orElseThrow(
                ()
                    -> new UserNotFoundException(
                        fromUserId, "招待元ユーザが見つかりませんでした。"));

    var invitedUserId = new UserId(command.getInvitedUserId());
    var invitedUser =
        userRepository.find(invitedUserId)
            .orElseThrow(
                ()
                    -> new UserNotFoundException(
                        invitedUserId, "招待先ユーザが見つかりませんでした。"));

    var circleId = new CircleId(command.getCircleId());
    var circle = circleRepository.find(circleId).orElseThrow(
        ()
            -> new CircleNotFoundException(circleId,
                                           "サークルが見つかりませんでした。"));

    if (circle.getMembers().size() >= 29) {
      throw new CircleFullException(circleId);
    }

    var circleInvitation = new CircleInvitation(circle, fromUser, invitedUser);
    circleInvitationRepository.save(circleInvitation);
  }
}
