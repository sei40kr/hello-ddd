package me.yong_ju.cqrs_and_event_sourcing.domain.service;

import static java.util.Collections.emptySet;
import java.util.Set;
import lombok.Value;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Address;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Contact;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.UserAddress;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.UserContact;
import me.yong_ju.cqrs_and_event_sourcing.domain.repository.IUserReadRepository;

/**
 * Projection is an important pattern which greatly benefits CQRS. Projection essentially means
 * representing domain objects in different shapes and structures.
 */
@Value
public class UserProjection {
  private final IUserReadRepository repository;

  public Set<Contact> handle(ContactByTypeQuery query) {
    var userContact = repository.getUserContact(query.getUserId());
    return userContact.map(UserContact::getContactByType).map(it -> it.get(query.getContactType()))
        .orElse(emptySet());
  }

  public Set<Address> handle(AddressByRegionQuery query) {
    var userAddress = repository.getUserAddress(query.getUserId());
    return userAddress.map(UserAddress::getAddressByRegion).map(it -> it.get(query.getState()))
        .orElse(emptySet());
  }
}
