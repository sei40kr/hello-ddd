package me.yong_ju.example_project.domain.persistence;

import java.util.Optional;
import me.yong_ju.example_project.domain.model.entity.Circle;
import me.yong_ju.example_project.domain.model.valueobject.CircleId;
import me.yong_ju.example_project.domain.model.valueobject.CircleName;

public interface ICircleRepository {
  void save(Circle circle);
  Optional<Circle> find(CircleId id);
  Optional<Circle> find(CircleName name);
}
