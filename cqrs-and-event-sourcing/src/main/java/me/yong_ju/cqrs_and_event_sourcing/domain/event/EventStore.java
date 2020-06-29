package me.yong_ju.cqrs_and_event_sourcing.domain.event;

import static java.util.Collections.emptyList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventStore {
    private final Map<String, List<Event>> store = new HashMap<>();

    public void addEvent(final String userId, final Event event) {
        store.putIfAbsent(userId, emptyList());
        store.get(userId).add(event);
    }
}
