package org.chernous.test.task.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.chernous.test.task.entity.Sensor;
import org.chernous.test.task.service.SensorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Validated
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable Long id) {
        return sensorService.getSensorById(id);
    }

    @PostMapping
    public Sensor createSensor(@Valid @RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }

    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable Long id, @Valid @RequestBody Sensor sensor) {
        return sensorService.updateSensor(id, sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
    }

    @GetMapping("/search")
    public List<Sensor> searchSensors(@RequestParam String name, @RequestParam String model) {
        return sensorService.searchSensors(name, model);
    }
}
