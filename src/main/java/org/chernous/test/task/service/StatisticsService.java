package org.chernous.test.task.service;

import org.chernous.test.task.entity.statistics.SensorStatistics;

import java.time.LocalDate;
import java.util.List;

public interface StatisticsService {

    void collectStatistics();
    List<SensorStatistics> getStatistics(LocalDate startDate, LocalDate endDate);
    List<SensorStatistics> findAll();
}
