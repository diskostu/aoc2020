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

    private static String inputDummyPart1;
    private static String inputDummyPart2;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        inputDummyPart1 = """
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

        // first 4 are invalid, the other 4 are valid
        inputDummyPart2 = """
            eyr:1972 cid:100
            hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926

            iyr:2019
            hcl:#602927 eyr:1967 hgt:170cm
            ecl:grn pid:012533040 byr:1946

            hcl:dab227 iyr:2012
            ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277

            hgt:59cm ecl:zzz
            eyr:2038 hcl:74454a iyr:2023
            pid:3556412378 byr:2007

            pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
            hcl:#623a2f

            eyr:2029 ecl:blu cid:129 byr:1989
            iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

            hcl:#888785
            hgt:164cm byr:2001 iyr:2015 cid:88
            pid:545766238 ecl:hzl
            eyr:2022

            iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
            """;

        inputReal = new InputFileSupplier("in/day04.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultAllPassports")
    public void testCountAllPassports(String input, long expectedResult) {
        final Day04 sut = new Day04(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getPassports().size());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    void testDay04Part1(String input, long expectedResult) {
        final Day04 sut = new Day04(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getValidPassportCountPart1());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    void testDay04Part2(String input, long expectedResult) {
        final Day04 sut = new Day04(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getValidPassportCountPart2());
    }


    private static Stream<Arguments> provideInputAndExpectedResultAllPassports() {
        return Stream.of(
            Arguments.of(inputDummyPart1, 4),
            Arguments.of(inputReal, 257)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummyPart1, 2),
            Arguments.of(inputReal, 228)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        return Stream.of(
            Arguments.of(inputDummyPart2, 4),
            Arguments.of(inputReal, 175)
        );
    }
}
