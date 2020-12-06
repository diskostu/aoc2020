package de.diskostu.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class Day04ValidationTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    @ParameterizedTest
    @CsvSource({"1920", "1960", "2002"})
    public void testBirthYearValid(final String value) {
        final Passport passport = new Passport();
        passport.setBirthYear(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "birthYear");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"1919", "2003", "0", "lala"})
    public void testBirthYearInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setBirthYear(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "birthYear");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }


    @ParameterizedTest
    @CsvSource({"2010", "2015", "2020"})
    public void testIssueYearValid(final String value) {
        final Passport passport = new Passport();
        passport.setIssueYear(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "issueYear");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"2009", "2021", "0", "lala"})
    public void testIssueYearInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setIssueYear(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "issueYear");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }


    @ParameterizedTest
    @CsvSource({"2020", "2025", "2030"})
    public void testExpirationYearValid(final String value) {
        final Passport passport = new Passport();
        passport.setExpirationYear(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "expirationYear");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"2019", "2031", "0", "lala"})
    public void testExpirationYearInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setExpirationYear(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "expirationYear");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }


    @ParameterizedTest
    @CsvSource({"150cm", "193cm", "59in", "76in"})
    public void testHeightValid(final String value) {
        final Passport passport = new Passport();
        passport.setHeight(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "height");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"0", "lala", "149cm", "194cm", "58in", "77in", "150in", "193in", "59cm", "76cm"})
    public void testHeightInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setHeight(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "height");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }


    @ParameterizedTest
    @CsvSource({"000000", "ffffff", "123abc", "abc123"})
    public void testHairColorValid(final String value) {
        final Passport passport = new Passport();
        passport.setHairColor("#" + value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "hairColor");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"00000", "fffffff", "123abg", "zbc123"})
    public void testHairColorInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setHairColor("#" + value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "hairColor");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }


    @ParameterizedTest
    @CsvSource({"amb", "blu", "brn", "gry", "grn", "hzl", "oth"})
    public void testEyeColorValid(final String value) {
        final Passport passport = new Passport();
        passport.setEyeColor(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "eyeColor");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"lal", "lol", "wtf"})
    public void testEyeColorInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setEyeColor(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "eyeColor");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }


    @ParameterizedTest
    @CsvSource({"000012345", "123450000", "000000000", "999999999"})
    public void testPassportIdValid(final String value) {
        final Passport passport = new Passport();
        passport.setPassportId(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "passportId");

        Assertions.assertTrue(violations.isEmpty());
    }


    @ParameterizedTest
    @CsvSource({"00001234", "a23450000", "1234567890"})
    public void testPassportIdInvalid(final String value) {
        final Passport passport = new Passport();
        passport.setPassportId(value);

        final Set<ConstraintViolation<Passport>> violations = validator.validateProperty(passport, "passportId");

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }
}
