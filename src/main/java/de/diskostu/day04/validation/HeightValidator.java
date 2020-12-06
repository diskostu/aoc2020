package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HeightValidator implements ConstraintValidator<ValidHeight, String> {

    private static final String REGEXP = "^[0-9]{1,3}[a-z]{1,2}";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || !value.matches(REGEXP)) {
            return false;
        }

        final int numericValue = Integer.parseInt(value.replaceAll("[^0-9]", ""));
        final String unitValue = value.replaceAll("[0-9]", "");

        return (unitValue.equals("cm") && numericValue >= 150 && numericValue <= 193) ||
            (unitValue.equals("in") && numericValue >= 59 && numericValue <= 76);
    }
}
