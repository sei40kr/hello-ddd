package me.yong_ju.example_project_with_unit_of_work.domain.entity;

import me.yong_ju.example_project_with_unit_of_work.domain.UnitOfWork;

abstract class Entity {
  protected void markNew() { UnitOfWork.current.registerNew(this); }
  protected void markDirty() { UnitOfWork.current.registerDirty(this); }
  protected void markClean() { UnitOfWork.current.registerClean(this); }
  protected void markDeleted() { UnitOfWork.current.registerDeleted(this); }
}
