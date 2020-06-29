package me.yong_ju.cqrs_and_event_sourcing.domain.service;

import java.util.Set;
import lombok.Value;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Address;
import me.yong_ju.cqrs_and_event_sourcing.domain.model.Contact;

@Value
public class UpdateUserCommand {
  private final String userId;
  private final Set<Address> addresses;
  private final Set<Contact> contacts;
}
