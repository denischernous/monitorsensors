package org.chernous.test.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Embeddable
public class Range {
    @NotNull(message = "Диапазон 'from' обязателен")
    @Positive(message = "Диапазон 'from' должен быть положительным числом")
    @Column(name = "range_from")
    private Integer from;

    @NotNull(message = "Диапазон 'to' обязателен")
    @Positive(message = "Диапазон 'to' должен быть положительным числом")
    @Column(name = "range_to")
    private Integer to;
}
