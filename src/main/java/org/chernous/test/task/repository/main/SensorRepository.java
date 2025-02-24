package org.chernous.test.task.repository.main;

import org.chernous.test.task.entity.Sensor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("mainEntityManagerFactory")
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNameContainingOrModelContaining(String name, String model);
}
