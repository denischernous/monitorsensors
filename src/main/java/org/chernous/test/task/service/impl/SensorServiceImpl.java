package org.chernous.test.task.service.impl;

import lombok.RequiredArgsConstructor;
import org.chernous.test.task.entity.Sensor;
import org.chernous.test.task.exception.ResourceNotFoundException;
import org.chernous.test.task.repository.main.SensorRepository;
import org.chernous.test.task.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private static final String SENSOR_NOT_FOUND = "Сенсор не найден!";

    private final SensorRepository sensorRepository;
    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(SENSOR_NOT_FOUND));
    }

    @Override
    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public Sensor updateSensor(Long id, Sensor sensorDetails) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(SENSOR_NOT_FOUND));
        sensor.setName(sensorDetails.getName());
        sensor.setModel(sensorDetails.getModel());
        sensor.setRange(sensorDetails.getRange());
        sensor.setType(sensorDetails.getType());
        sensor.setUnit(sensorDetails.getUnit());
        sensor.setLocation(sensorDetails.getLocation());
        sensor.setDescription(sensorDetails.getDescription());
        return sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensor(Long id) {
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(SENSOR_NOT_FOUND));
        sensorRepository.delete(sensor);
    }

    @Override
    public List<Sensor> searchSensors(String name, String model) {
        return sensorRepository.findByNameContainingOrModelContaining(name, model);
    }
}
