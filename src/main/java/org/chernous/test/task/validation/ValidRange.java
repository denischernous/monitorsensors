package org.chernous.test.task.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangeValidator.class)
@Documented
public @interface ValidRange {
    String message() default "Range 'from' must be less than 'to'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
