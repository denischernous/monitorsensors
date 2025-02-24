package org.chernous.test.task.service.impl;

import lombok.RequiredArgsConstructor;
import org.chernous.test.task.entity.Sensor;
import org.chernous.test.task.entity.enums.SensorType;
import org.chernous.test.task.entity.statistics.SensorStatistics;
import org.chernous.test.task.repository.main.SensorRepository;
import org.chernous.test.task.repository.statistics.SensorStatisticsRepository;
import org.chernous.test.task.service.StatisticsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final SensorRepository sensorRepository;
    private final SensorStatisticsRepository statisticsRepository;

    @Override
    @Scheduled(cron = "${statistics.cron}") // Запуск каждый день в 02:00
    public void collectStatistics() {
        LocalDate today = LocalDate.now();

        List<Sensor> sensors = sensorRepository.findAll();

        int totalSensors = sensors.size();
        int pressureSensors = (int) sensors.stream().filter(s -> SensorType.PRESSURE.equals(s.getType())).count();
        int voltageSensors = (int) sensors.stream().filter(s -> SensorType.VOLTAGE.equals(s.getType())).count();
        int temperatureSensors = (int) sensors.stream().filter(s -> SensorType.TEMPERATURE.equals(s.getType())).count();
        int humiditySensors = (int) sensors.stream().filter(s -> SensorType.HUMIDITY.equals(s.getType())).count();

        SensorStatistics statistics = new SensorStatistics();
        statistics.setDate(today);
        statistics.setTotalSensors(totalSensors);
        statistics.setPressureSensors(pressureSensors);
        statistics.setVoltageSensors(voltageSensors);
        statistics.setTemperatureSensors(temperatureSensors);
        statistics.setHumiditySensors(humiditySensors);

        statisticsRepository.save(statistics);
    }

    public List<SensorStatistics> getStatistics(LocalDate startDate, LocalDate endDate) {
        return statisticsRepository.findByDateBetween(startDate, endDate);
    }

    public List<SensorStatistics> findAll() {
        return statisticsRepository.findAll();
    }
}
