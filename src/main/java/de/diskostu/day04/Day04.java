package de.diskostu.day04;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day04 {

    private final List<String> rows;

    private final static List<String> requiredKeys = Arrays.asList("byr", "ecl", "eyr", "hcl", "hgt", "iyr", "pid");


    public Day04(InputSupplier inputSupplier) {
        rows = inputSupplier.get()
                            .collect(Collectors.toList());
    }


    public long getValidPassportCount() {
        long validPassports = 0;

        final List<String> keys = new ArrayList<>();

        for (final String row : rows) {
            if (row.isBlank()) {
                if (keys.containsAll(requiredKeys)) {
                    validPassports++;
                }

                keys.clear();
            } else {
                final String[] keyValuePairs = row.split(" ");
                for (String keyValuePair : keyValuePairs) {
                    keys.add(keyValuePair.split(":")[0]);
                }
            }
        }

        // beware: we have to check if the last block is valid
        return keys.isEmpty() || !keys.containsAll(requiredKeys) ? validPassports : validPassports + 1;
    }
}
