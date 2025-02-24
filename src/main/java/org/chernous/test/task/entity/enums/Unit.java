package org.chernous.test.task.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/*
    Единица измерения
 */
public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("°C"),
    PERCENT("%");

    private final String value;

    Unit(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static Unit fromString(String value) {
        for (Unit unit : Unit.values()) {
            if (unit.value.equalsIgnoreCase(value)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Unknown unit: " + value);
    }
}
