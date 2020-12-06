package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * four digits; at least 1920 and at most 2002
 */
public class BirthYearValidator implements ConstraintValidator<ValidBirthYear, String> {

    private static final String REGEXP = "^[0-9]{4}";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || !value.matches(REGEXP)) {
            return false;
        }

        final int numericValue = Integer.parseInt(value);

        return numericValue >= 1920 && numericValue <= 2002;
    }
}
