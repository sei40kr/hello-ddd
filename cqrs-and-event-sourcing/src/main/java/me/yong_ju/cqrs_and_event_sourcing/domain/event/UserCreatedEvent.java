package me.yong_ju.cqrs_and_event_sourcing.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class UserCreatedEvent extends Event {
    private final String userId;
    private final String firstName;
    private final String lastName;
}
