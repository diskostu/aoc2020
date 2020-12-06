package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * four digits; at least 2020 and at most 2030
 */
public class ExpirationYearValidator implements ConstraintValidator<ValidExpirationYear, String> {

    private static final String REGEXP = "^[0-9]{4}";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || !value.matches(REGEXP)) {
            return false;
        }

        final int numericValue = Integer.parseInt(value);

        return numericValue >= 2020 && numericValue <= 2030;
    }
}
