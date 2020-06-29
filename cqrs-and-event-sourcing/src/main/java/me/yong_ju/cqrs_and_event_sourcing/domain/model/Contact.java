package me.yong_ju.cqrs_and_event_sourcing.domain.model;

import lombok.Value;

@Value
public class Contact {
  private final String type;
  private final String detail;
}
