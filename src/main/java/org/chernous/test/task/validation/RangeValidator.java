package org.chernous.test.task.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.chernous.test.task.entity.Range;

public class RangeValidator implements ConstraintValidator<ValidRange, Range> {

    @Override
    public boolean isValid(Range range, ConstraintValidatorContext context) {
        if (range == null || range.getFrom() == null || range.getTo() == null) {
            return false;
        }
        return range.getFrom() < range.getTo();
    }
}
