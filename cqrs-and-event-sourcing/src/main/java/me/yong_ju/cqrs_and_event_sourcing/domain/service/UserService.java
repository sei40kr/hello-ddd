package me.yong_ju.cqrs_and_event_sourcing.domain.service;

import static java.util.stream.Collectors.toSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.EventStore;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserAddressAddedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserAddressRemovedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserContactAddedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserContactRemovedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserCreatedEvent;
import me.yong_ju.cqrs_and_event_sourcing.domain.event.UserUtility;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Address;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Contact;

@RequiredArgsConstructor
public class UserService {
    private final EventStore eventStore;

    public void createUser(final String userId, final String firstName, final String lastName) {
        eventStore.addEvent(userId, new UserCreatedEvent(userId, firstName, lastName));
    }

    public void updateUser(final String userId, final Set<Contact> contacts,
            final Set<Address> addresses) {
        // Generating the current state of the domain model by replaying all the domain events
        // generated so far. Of course, in a real application, this is not a feasible strategy, and
        // we'll have to maintain a local cache to avoid generating the state every time.
        final var user = UserUtility.recreateUserState(eventStore, userId);
        user.getContacts().stream().filter(it -> !contacts.contains(it)).forEach(it -> eventStore
                .addEvent(userId, new UserContactRemovedEvent(it.getType(), it.getDetail())));
        contacts.stream().filter(it -> !user.getContacts().contains(it)).forEach(it -> eventStore
                .addEvent(userId, new UserContactAddedEvent(it.getType(), it.getDetail())));

        user.getAddresses().stream().filter(it -> !addresses.contains(it))
                .forEach(it -> eventStore.addEvent(userId, new UserAddressRemovedEvent(it.getCity(),
                        it.getState(), it.getPostalCode())));
        addresses.stream().filter(it -> !user.getAddresses().contains(it))
                .forEach(it -> eventStore.addEvent(userId, new UserAddressAddedEvent(it.getCity(),
                        it.getState(), it.getPostalCode())));
    }

    public Set<Contact> getContactByType(final String userId, final String contactType) {
        final var user = UserUtility.recreateUserState(eventStore, userId);
        return user.getContacts().stream().filter(it -> it.getType().equals(contactType))
                .collect(toSet());
    }

    public Set<Address> getAddressByType(final String userId, final String state) {
        final var user = UserUtility.recreateUserState(eventStore, userId);
        return user.getAddresses().stream().filter(it -> it.getState().equals(state))
                .collect(toSet());
    }
}
