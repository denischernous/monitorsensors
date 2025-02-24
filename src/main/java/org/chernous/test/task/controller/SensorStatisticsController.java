package org.chernous.test.task.controller;

import lombok.RequiredArgsConstructor;
import org.chernous.test.task.entity.statistics.SensorStatistics;
import org.chernous.test.task.service.StatisticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class SensorStatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping("/all")
    public List<SensorStatistics> getAllStatistics() {
        return statisticsService.findAll();
    }

    @GetMapping
    public List<SensorStatistics> getStatistics(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return statisticsService.getStatistics(startDate, endDate);
    }
}
