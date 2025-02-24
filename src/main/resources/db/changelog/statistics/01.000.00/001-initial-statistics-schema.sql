-- liquibase formatted sql

-- changeset denis:1
CREATE TABLE sensor_statistics (
    id BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL,
    total_sensors INT NOT NULL,
    pressure_sensors INT NOT NULL,
    voltage_sensors INT NOT NULL,
    temperature_sensors INT NOT NULL,
    humidity_sensors INT NOT NULL
);

-- changeset denis:2
INSERT INTO sensor_statistics (date, total_sensors, pressure_sensors, voltage_sensors, temperature_sensors, humidity_sensors)
VALUES
    ('2023-10-01', 100, 20, 30, 25, 25),
    ('2023-10-02', 110, 22, 33, 28, 27),
    ('2023-10-03', 95, 18, 32, 22, 23),
    ('2023-10-04', 120, 25, 35, 30, 29),
    ('2023-10-05', 105, 21, 31, 26, 24);

-- rollback DROP TABLE sensor_statistics;