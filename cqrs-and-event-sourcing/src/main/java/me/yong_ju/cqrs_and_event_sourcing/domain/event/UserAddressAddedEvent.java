package me.yong_ju.cqrs_and_event_sourcing.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class UserAddressAddedEvent extends Event {
    private final String city;
    private final String state;
    private final String postalCode;
}
