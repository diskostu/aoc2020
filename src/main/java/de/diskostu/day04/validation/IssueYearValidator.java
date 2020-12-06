package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * four digits; at least 2010 and at most 2020
 */
public class IssueYearValidator implements ConstraintValidator<ValidIssueYear, String> {

    private static final String REGEXP = "^[0-9]{4}";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || !value.matches(REGEXP)) {
            return false;
        }

        final int numericValue = Integer.parseInt(value);

        return numericValue >= 2010 && numericValue <= 2020;
    }
}
