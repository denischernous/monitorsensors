package org.chernous.test.task.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.chernous.test.task.entity.enums.Unit;

@Converter(autoApply = true)
public class UnitConverter implements AttributeConverter<Unit, String> {

    @Override
    public String convertToDatabaseColumn(Unit attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public Unit convertToEntityAttribute(String dbData) {
        return dbData != null ? Unit.fromString(dbData) : null;
    }
}