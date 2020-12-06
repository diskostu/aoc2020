package de.diskostu.day04;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day04 {

    private final List<String> rows;


    public Day04(InputSupplier inputSupplier) {
        rows = inputSupplier.get()
                            .collect(Collectors.toList());
    }


    public List<Passport> getPassports() {
        final List<Passport> passports = new ArrayList<>();
        Passport passport = new Passport();

        for (final String row : rows) {
            if (row.isBlank()) {
                // passport finished
                passports.add(passport);
                passport = new Passport();
            } else {
                final String[] keyValuePairs = row.split(" ");
                for (final String keyValuePair : keyValuePairs) {
                    final String[] keyValuePairSplit = keyValuePair.split(":");

                    Passport.RequiredField enumName;
                    try {
                        enumName = Passport.RequiredField.valueOf(keyValuePairSplit[0]);
                    } catch (IllegalArgumentException exception) {
                        // we don't care if a non-mandatory key is found
                        continue;
                    }

                    final String value = keyValuePairSplit[1];

                    switch (enumName) {
                        case byr -> passport.setBirthYear(value);
                        case iyr -> passport.setIssueYear(value);
                        case eyr -> passport.setExpirationYear(value);
                        case hgt -> passport.setHeight(value);
                        case hcl -> passport.setHairColor(value);
                        case ecl -> passport.setEyeColor(value);
                        case pid -> passport.setPassportId(value);
                    }
                }
            }
        }

        // don't forget the last one
        if (!passport.isEmpty()) {
            passports.add(passport);
        }

        return passports;
    }


    public long getValidPassportCountPart1() {
        final List<Passport> passports = getPassports();

        return passports.stream()
                        .filter(Passport::isAllFieldsSet)
                        .count();
    }


    public long getValidPassportCountPart2() {
        final List<Passport> passports = getPassports();

        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        return passports.stream()
                        .filter(s -> validator.validate(s).isEmpty())
                        .count();
    }
}
