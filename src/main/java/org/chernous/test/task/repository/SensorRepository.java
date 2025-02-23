package org.chernous.test.task.repository;

import org.chernous.test.task.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNameContainingOrModelContaining(String name, String model);
}
