package me.yong_ju.cqrs_and_event_sourcing.domain.model;

import java.util.Set;
import lombok.Data;

@Data
public class User {
  private String userId;
  private String firstName;
  private String lastName;
  private Set<Contact> contacts;
  private Set<Address> addresses;

  public User(String userId, String firstName, String lastName) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
