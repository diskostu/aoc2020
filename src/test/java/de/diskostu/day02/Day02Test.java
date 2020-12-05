package de.diskostu.day02;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 02")
class Day02Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // part 1: 2 OK (#2, #4, #5)
        // part 2: 3 OK (#2, #4, #5)
        inputDummy = """
            1-3 a: bbbbbbb
            1-3 a: abbbbbb
            1-3 a: aaaabbb
            4-6 b: bbbbbab
            3-5 b: ababbba
            3-5 b: bbbbbbb
            """;

        // ??? OK
        inputReal = new InputFileSupplier("in/day02.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    void testPasswordRulesPart1(String input, long expectedResult) {
        final Day02 sut = new Day02(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getCompliantPasswordsCountPart1());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    void testPasswordRulesPart2(String input, long expectedResult) {
        final Day02 sut = new Day02(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getCompliantPasswordsCountPart2());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 3),
            Arguments.of(inputReal, 414)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        return Stream.of(
            Arguments.of(inputDummy, 3),
            Arguments.of(inputReal, 413)
        );
    }
}
