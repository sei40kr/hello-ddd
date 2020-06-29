package me.yong_ju.cqrs_and_event_sourcing.domain.service;

import lombok.Value;

@Value
public class AddressByRegionQuery {
  private final String userId;
  private final String state;
}
