package me.yong_ju.cqrs_and_event_sourcing.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.Data;

@Data
public class UserContact {
  private Map<String, Set<Contact>> contactByType = new HashMap<>();
}
