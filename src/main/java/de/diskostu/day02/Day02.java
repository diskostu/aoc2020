package de.diskostu.day02;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("DuplicatedCode")
@Log4j2
public class Day02 {
    private final List<String> rulesAndPasswords;


    public Day02(InputSupplier inputSupplier) {
        rulesAndPasswords = inputSupplier.get()
                                         .collect(Collectors.toList());
    }


    public long getCompliantPasswordsCountPart1() {
        long compliantPasswordCount = 0;

        for (final String ruleAndPassword : rulesAndPasswords) {
            final String[] stringContents = getStringContents(ruleAndPassword);

            final int minCount = Integer.parseInt(stringContents[0]);
            final int maxCount = Integer.parseInt(stringContents[1]);
            final char charToCheck = stringContents[2].charAt(0);
            final String passwordToCheck = stringContents[3];

            final long charCount = passwordToCheck.chars().filter(value -> value == charToCheck).count();

            if (charCount >= minCount && charCount <= maxCount) {
                compliantPasswordCount++;
            }
        }

        return compliantPasswordCount;
    }


    public long getCompliantPasswordsCountPart2() {
        long compliantPasswordCount = 0;

        for (final String ruleAndPassword : rulesAndPasswords) {
            final String[] stringContents = getStringContents(ruleAndPassword);

            final int pos1 = Integer.parseInt(stringContents[0]);
            final int pos2 = Integer.parseInt(stringContents[1]);
            final char charToCheck = stringContents[2].charAt(0);
            final String passwordToCheck = stringContents[3];

            final char char1 = passwordToCheck.charAt(pos1 - 1);
            final char char2 = passwordToCheck.charAt(pos2 - 1);

            if (char1 == charToCheck ^ char2 == charToCheck) {
                compliantPasswordCount++;
            }
        }

        return compliantPasswordCount;
    }


    private static String[] getStringContents(final String s) {
        String[] split = s.split("-");
        final String number1 = split[0];
        String remaining = split[1];

        split = remaining.split(" ");
        final String number2 = split[0];
        final String charToCheck = split[1].substring(0, 1);
        final String passwordToCheck = split[2];

        return new String[]{number1, number2, charToCheck, passwordToCheck};
    }
}
