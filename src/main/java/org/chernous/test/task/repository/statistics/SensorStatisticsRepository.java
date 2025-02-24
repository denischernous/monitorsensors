package org.chernous.test.task.repository.statistics;

import org.chernous.test.task.entity.statistics.SensorStatistics;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Qualifier("statisticsEntityManagerFactory")
public interface SensorStatisticsRepository extends JpaRepository<SensorStatistics, Long> {
    List<SensorStatistics> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
