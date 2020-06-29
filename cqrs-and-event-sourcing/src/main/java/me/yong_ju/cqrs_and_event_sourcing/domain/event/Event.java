package me.yong_ju.cqrs_and_event_sourcing.domain.event;

import java.util.Date;
import java.util.UUID;

public abstract class Event {
    protected final UUID id = UUID.randomUUID();
    protected final Date created = new Date();
}
