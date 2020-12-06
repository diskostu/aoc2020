package de.diskostu.day04.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * a # followed by exactly six characters 0-9 or a-f
 */
public class HairColorValidator implements ConstraintValidator<ValidHairColor, String> {

    private static final String REGEXP = "^#[0-9a-f]{6}";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && value.matches(REGEXP);
    }
}
