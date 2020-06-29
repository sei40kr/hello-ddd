package me.yong_ju.cqrs_and_event_sourcing.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class UserContactRemovedEvent extends Event {
    private final String contactType;
    private final String contactDetails;
}
