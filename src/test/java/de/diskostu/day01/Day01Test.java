package de.diskostu.day01;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 01")
class Day01Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        inputDummy = """
            100
            200
            300
            400
            500
            1720
            1920
            """;

        inputReal = new InputFileSupplier("in/day01.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultForTwo")
    void testTwoNumbersShouldAddUpTo2020(String input, long expectedResult) {
        final Day01 day01 = new Day01(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, day01.solution2());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultForThree")
    void testThreeNumbersShouldAddUpTo2020(String input, long expectedResult) {
        final Day01 day01 = new Day01(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, day01.solution3());
    }


    private static Stream<Arguments> provideInputAndExpectedResultForTwo() {
        return Stream.of(
            Arguments.of(inputDummy, 192000),
            Arguments.of(inputReal, 928896)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultForThree() {
        return Stream.of(
            Arguments.of(inputDummy, 34400000),
            Arguments.of(inputReal, 295668576)
        );
    }
}
