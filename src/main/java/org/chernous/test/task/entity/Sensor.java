package org.chernous.test.task.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.chernous.test.task.entity.converter.SensorTypeConverter;
import org.chernous.test.task.entity.converter.UnitConverter;
import org.chernous.test.task.entity.enums.SensorType;
import org.chernous.test.task.entity.enums.Unit;
import org.chernous.test.task.validation.ValidRange;

@Data
@Entity
@ValidRange(message = "Диапазон 'from' должно быть меньше 'to'")
@Table(name = "sensors")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя обязательно")
    @Size(min = 3, max = 30, message = "Количество символов должно быть не меньше 3 и не превышать 30")
    private String name;

    @NotBlank(message = "Модель обязательна")
    @Size(max = 15, message = "Количество символов не должно превышает 15")
    private String model;

    @Embedded
    @Valid
    @NotNull(message = "Диапазон обязателен")
    private Range range;

    @Convert(converter = SensorTypeConverter.class)
    @NotNull(message = "Тип обязателен")
    private SensorType type;

    @Convert(converter = UnitConverter.class)
    private Unit unit;

    @Size(max = 40, message = "Местоположение сенсора долно быть не больше 40 символов")
    private String location;

    @Size(max = 200, message = "Описание датчика должна быть не больше 200 символов")
    private String description;
}
