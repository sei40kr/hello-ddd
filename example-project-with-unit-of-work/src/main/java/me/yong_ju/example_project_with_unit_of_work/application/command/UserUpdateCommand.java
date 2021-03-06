package me.yong_ju.example_project_with_unit_of_work.application.command;

public class UserUpdateCommand {
  private final String id;
  private String name;
  private String mailAddress;

  public UserUpdateCommand(String id) { this.id = id; }

  public String getId() { return id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getMailAddress() { return mailAddress; }

  public void setMailAddress(String mailAddress) {
    this.mailAddress = mailAddress;
  }
}
