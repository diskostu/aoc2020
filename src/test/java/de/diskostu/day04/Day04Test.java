package de.diskostu.day04;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 04")
class Day04Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        inputDummy = """
            ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
            byr:1937 iyr:2017 cid:147 hgt:183cm

            iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
            hcl:#cfa07d byr:1929

            hcl:#ae17e1 iyr:2013
            eyr:2024
            ecl:brn pid:760753108 byr:1931
            hgt:179cm

            hcl:#cfa07d eyr:2025 pid:166559648
            iyr:2011 ecl:brn hgt:59in
            """;

        inputReal = new InputFileSupplier("in/day04.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    void testDay04Part1(String input, long expectedResult) {
        final Day04 sut = new Day04(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getValidPassportCount());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 2),
            Arguments.of(inputReal, 228)
        );
    }
}
