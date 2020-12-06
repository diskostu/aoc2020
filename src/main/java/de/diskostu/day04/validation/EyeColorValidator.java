package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * exactly one of: amb blu brn gry grn hzl oth
 */
public class EyeColorValidator implements ConstraintValidator<ValidEyeColor, String> {

    private static final List<String> validEyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return validEyeColors.contains(value);
    }
}
