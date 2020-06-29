package me.yong_ju.cqrs_and_event_sourcing.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.Event;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserAddressAddedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserAddressRemovedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserContactAddedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserContactRemovedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Address;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Contact;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.UserAddress;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.UserContact;
import me.yong_ju.cqrs_and_event_sourcing.domain.repository.IUserReadRepository;

/**
 * Projector has the logic to project the write domain model into the read domain model.
 */
@RequiredArgsConstructor
public class UserProjector {
  private final IUserReadRepository repository;

  public void project(final String userId, final List<Event> events) {
    events.forEach(it -> {
      if (it instanceof UserAddressAddedEvent) {
        apply(userId, (UserAddressAddedEvent) it);
      } else if (it instanceof UserAddressRemovedEvent) {
        apply(userId, (UserAddressRemovedEvent) it);
      } else if (it instanceof UserContactAddedEvent) {
        apply(userId, (UserContactAddedEvent) it);
      } else if (it instanceof UserContactRemovedEvent) {
        apply(userId, (UserContactRemovedEvent) it);
      }
    });
  }

  private void apply(final String userId, final UserAddressAddedEvent event) {
    final var address = new Address(event.getCity(), event.getState(), event.getPostalCode());
    final var userAddress = repository.getUserAddress(userId).orElse(new UserAddress());
    final var addresses = Optional
        .ofNullable(userAddress.getAddressByRegion().get(address.getState())).orElse(Set.of());
    addresses.add(address);
    userAddress.getAddressByRegion().put(address.getState(), addresses);
    repository.addUserAddress(userId, userAddress);
  }

  private void apply(final String userId, final UserAddressRemovedEvent event) {
    final var address = new Address(event.getCity(), event.getState(), event.getPostalCode());
    final var optionalUserAddress = repository.getUserAddress(userId);
    optionalUserAddress.map(UserAddress::getAddressByRegion).map(it -> it.get(address.getState()))
        .ifPresent(it -> it.remove(address));
    optionalUserAddress.ifPresent(it -> repository.addUserAddress(userId, it));
  }

  private void apply(final String userId, final UserContactAddedEvent event) {
    final var contact = new Contact(event.getContactType(), event.getContactDetails());
    final var userContact = repository.getUserContact(userId).orElse(new UserContact());
    final var contacts =
        Optional.ofNullable(userContact.getContactByType().get(contact.getType())).orElse(Set.of());
    contacts.add(contact);
    userContact.getContactByType().put(contact.getType(), contacts);
    repository.addUserContact(userId, userContact);
  }

  private void apply(final String userId, final UserContactRemovedEvent event) {
    final var contact = new Contact(event.getContactType(), event.getContactDetails());
    final var optionalUserContact = repository.getUserContact(userId);
    optionalUserContact.map(UserContact::getContactByType).map(it -> it.get(contact.getType()))
        .ifPresent(it -> it.remove(contact));
    optionalUserContact.ifPresent(it -> repository.addUserContact(userId, it));
  }
}
