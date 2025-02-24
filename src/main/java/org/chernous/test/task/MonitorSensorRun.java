package org.chernous.test.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorSensorRun {
    public static void main(String[] args) {
        SpringApplication.run(MonitorSensorRun.class, args);
    }
}