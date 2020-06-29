package me.yong_ju.example_project_with_unit_of_work.application.dto;

public class UserData {
  public final String id;
  public final String name;
  public final String mailAddress;

  public UserData(final String id, final String name,
                  final String mailAddress) {
    this.id = id;
    this.name = name;
    this.mailAddress = mailAddress;
  }
}
