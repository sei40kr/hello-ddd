package me.yong_ju.cqrs_and_event_sourcing.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.Data;

@Data
public class UserAddress {
  private Map<String, Set<Address>> addressByRegion = new HashMap<>();
}
