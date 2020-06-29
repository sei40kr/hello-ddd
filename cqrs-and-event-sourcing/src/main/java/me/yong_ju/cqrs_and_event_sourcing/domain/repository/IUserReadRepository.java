package me.yong_ju.cqrs_and_event_sourcing.domain.repository;

import java.util.Optional;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.UserAddress;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.UserContact;

public interface IUserReadRepository {
  Optional<UserContact> getUserContact(String userId);

  Optional<UserAddress> getUserAddress(String userId);

  void addUserContact(String userId, UserContact userContact);

  void addUserAddress(String userId, UserAddress userAddress);
}
