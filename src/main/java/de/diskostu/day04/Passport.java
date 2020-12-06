package de.diskostu.day04;

import de.diskostu.day04.validation.ValidBirthYear;
import de.diskostu.day04.validation.ValidExpirationYear;
import de.diskostu.day04.validation.ValidEyeColor;
import de.diskostu.day04.validation.ValidHairColor;
import de.diskostu.day04.validation.ValidHeight;
import de.diskostu.day04.validation.ValidIssueYear;
import de.diskostu.day04.validation.ValidPassportId;
import lombok.Data;

import java.lang.reflect.Field;

@Data
public class Passport {

    @ValidBirthYear
    private String birthYear;

    @ValidIssueYear
    private String issueYear;

    @ValidExpirationYear
    private String expirationYear;

    @ValidHeight
    private String height;

    @ValidHairColor
    private String hairColor;

    @ValidEyeColor
    private String eyeColor;

    @ValidPassportId
    private String passportId;


    public boolean isEmpty() {
        return this.equals(new Passport());
    }


    public boolean isAllFieldsSet() {
        for (final Field field : getClass().getDeclaredFields()) {
            try {
                if (field.get(this) == null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("oops! field " + field.getName() + " is not accessible.");
            }
        }

        return true;
    }


    public enum RequiredField {
        byr, iyr, eyr, hgt, hcl, ecl, pid
    }
}
