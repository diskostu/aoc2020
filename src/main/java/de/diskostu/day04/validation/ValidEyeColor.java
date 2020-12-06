package de.diskostu.day04.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EyeColorValidator.class})
public @interface ValidEyeColor {

    String message() default "exactly one of: amb blu brn gry grn hzl oth.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
