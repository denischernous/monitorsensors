package org.chernous.test.task.service.impl;

import lombok.RequiredArgsConstructor;
import org.chernous.test.task.entity.Sensor;
import org.chernous.test.task.entity.enums.SensorType;
import org.chernous.test.task.repository.SensorRepository;
import org.chernous.test.task.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final SensorRepository sensorRepository;

    @Override
    public Map<String, Object> collectStatistics() {
        List<Sensor> sensors = sensorRepository.findAll();
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("totalSensors", sensors.size());

        Map<SensorType, Long> sensorsByType = new EnumMap<>(SensorType.class);
        for (Sensor sensor : sensors) {
            sensorsByType.put(sensor.getType(), sensorsByType.getOrDefault(sensor.getType(), 0L) + 1);
        }
        statistics.put("sensorsByType", sensorsByType);

        return statistics;
    }
}
