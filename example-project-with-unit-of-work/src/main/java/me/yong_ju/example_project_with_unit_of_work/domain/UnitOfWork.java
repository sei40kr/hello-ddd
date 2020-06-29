package me.yong_ju.example_project_with_unit_of_work.domain;

public class UnitOfWork {
  public static UnitOfWork current;

  public UnitOfWork() { current = this; }

  // TODO implement this
  public void registerNew(Object entity) {}
  public void registerDirty(Object entity) {}
  public void registerClean(Object entity) {}
  public void registerDeleted(Object entity) {}
  public void registerCommit(Object entity) {}
}
