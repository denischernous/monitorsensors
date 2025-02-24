package org.chernous.test.task.entity.statistics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "sensor_statistics")
public class SensorStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    @Column(name = "total_sensors", nullable = false)
    private int totalSensors;
    @Column(name = "pressure_sensors", nullable = false)
    private int pressureSensors;
    @Column(name = "voltage_sensors", nullable = false)
    private int voltageSensors;
    @Column(name = "temperature_sensors", nullable = false)
    private int temperatureSensors;
    @Column(name = "humidity_sensors", nullable = false)
    private int humiditySensors;

}
