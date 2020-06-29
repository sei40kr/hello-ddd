package me.yong_ju.cqrs_and_event_sourcing.domain.model;

import lombok.Value;

@Value
public class Address {
  private final String city;
  private final String state;
  private final String postalCode;
}
