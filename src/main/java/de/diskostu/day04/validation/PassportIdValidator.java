package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * a nine-digit number, including leading zeroes
 */
public class PassportIdValidator implements ConstraintValidator<ValidPassportId, String> {

    private static final String REGEXP = "^[0-9]{9}";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.matches(REGEXP);
    }
}
