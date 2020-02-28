package me.yong_ju.example_project.domain.factory;

import me.yong_ju.example_project.domain.model.entity.Circle;
import me.yong_ju.example_project.domain.model.entity.User;
import me.yong_ju.example_project.domain.model.valueobject.CircleName;

public interface ICircleFactory { Circle create(CircleName name, User owner); }
