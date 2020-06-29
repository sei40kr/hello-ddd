package me.yong_ju.cqrs_and_event_sourcing.domain.service;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.Event;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.EventStore;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserAddressAddedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserAddressRemovedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserContactAddedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserContactRemovedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserCreatedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserUtility;

/**
 * Aggregate is a pattern described in DDD that logically groups different entities by binding
 * entities to an aggregate root.
 */
@RequiredArgsConstructor
public class UserAggregate {
  private final EventStore eventStore;

  public List<Event> handleCreateUserCommand(final CreateUserCommand command) {
    final var event =
        new UserCreatedEvent(command.getUserId(), command.getFirstName(), command.getLastName());
    eventStore.addEvent(command.getUserId(), event);
    return List.of(event);
  }

  public List<Event> handleUpdateUserCommand(final UpdateUserCommand command) {
    final var user = UserUtility.recreateUserState(eventStore, command.getUserId());

    final var contactRemovedEvents =
        user.getContacts().stream().filter(it -> !command.getContacts().contains(it))
            .map(it -> new UserContactRemovedEvent(it.getType(), it.getDetail())).collect(toList());
    contactRemovedEvents.forEach(it -> eventStore.addEvent(command.getUserId(), it));

    final var contactAddedEvents =
        command.getContacts().stream().filter(it -> !user.getContacts().contains(it))
            .map(it -> new UserContactAddedEvent(it.getType(), it.getDetail())).collect(toList());
    contactAddedEvents.forEach(it -> eventStore.addEvent(command.getUserId(), it));

    final var addressRemovedEvents =
        user.getAddresses().stream().filter(it -> !command.getAddresses().contains(it))
            .map(it -> new UserAddressRemovedEvent(it.getCity(), it.getState(), it.getPostalCode()))
            .collect(toList());
    addressRemovedEvents.forEach(it -> eventStore.addEvent(command.getUserId(), it));

    final var addressAddedEvents =
        command.getAddresses().stream().filter(it -> !user.getAddresses().contains(it))
            .map(it -> new UserAddressAddedEvent(it.getCity(), it.getState(), it.getPostalCode()))
            .collect(toList());
    addressAddedEvents.forEach(it -> eventStore.addEvent(command.getUserId(), it));

    final List<Event> events = new ArrayList<>(contactAddedEvents.size()
        + contactRemovedEvents.size() + addressRemovedEvents.size() + addressAddedEvents.size());
    events.addAll(contactAddedEvents);
    events.addAll(contactRemovedEvents);
    events.addAll(addressAddedEvents);
    events.addAll(addressRemovedEvents);
    return events;
  }
}
