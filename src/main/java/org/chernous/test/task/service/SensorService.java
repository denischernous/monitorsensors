package org.chernous.test.task.service;

import org.chernous.test.task.entity.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> getAllSensors();
    Sensor getSensorById(Long id);
    Sensor createSensor(Sensor sensor);
    Sensor updateSensor(Long id, Sensor sensorDetails);
    void deleteSensor(Long id);
    List<Sensor> searchSensors(String name, String model);
}
