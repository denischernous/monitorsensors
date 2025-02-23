package org.chernous.test.task.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.chernous.test.task.entity.enums.SensorType;

@Converter(autoApply = true)
public class SensorTypeConverter implements AttributeConverter<SensorType, String> {

    @Override
    public String convertToDatabaseColumn(SensorType attribute) {
        return attribute != null ? attribute.getValue() : null; // Преобразование enum в строку
    }

    @Override
    public SensorType convertToEntityAttribute(String dbData) {
        return dbData != null ? SensorType.fromString(dbData) : null; // Преобразование строки в enum
    }
}
