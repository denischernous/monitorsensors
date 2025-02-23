package org.chernous.test.task.scheduler;

import lombok.RequiredArgsConstructor;
import org.chernous.test.task.service.StatisticsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatisticsScheduler {

    private final StatisticsService statisticsService;

    @Scheduled(cron = "${statistics.cron}")
    public void collectStatisticsDaily() {
        statisticsService.collectStatistics();
    }
}
