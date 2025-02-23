-- liquibase formatted sql

-- changeset :Chernous Denis localFilePath: 01.000.00/001-initial-schema.sql
CREATE TABLE sensors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    model VARCHAR(15) NOT NULL,
    range_from INT NOT NULL,
    range_to INT NOT NULL,
    type VARCHAR(20) NOT NULL,
    unit VARCHAR(20) NOT NULL,
    location VARCHAR(40),
    description VARCHAR(200)
);

-- Добавление предустановленных датчиков
INSERT INTO sensors (name, model, type, range_from, range_to, unit, location, description)
VALUES
    ('Barometer', 'ac-23', 'Pressure', 22, 45, 'bar', 'Kitchen', 'Measures atmospheric pressure'),
    ('Thermometer', 'th-100', 'Temperature', -10, 50, '°C', 'Living Room', 'Measures room temperature'),
    ('Hygrometer', 'hg-5', 'Humidity', 10, 90, '%', 'Bathroom', 'Tracks humidity levels'),
    ('VoltSensor', 'v-200', 'Voltage', 110, 240, 'voltage', 'Basement', 'Monitors electrical voltage');


-- rollback DROP TABLE sensors;