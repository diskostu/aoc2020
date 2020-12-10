package de.diskostu.day09;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 09")
class Day09Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // part 1: 127
        // part 2: 62
        inputDummy = """
            35
            20
            15
            25
            47
            40
            62
            55
            65
            95
            102
            117
            150
            182
            127
            219
            299
            277
            309
            576
            """;

        inputReal = new InputFileSupplier("in/day09.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    public void testCalculateSumsPart1(final String input, final int preambelLength, final int expectedNumber) {
        final Day09 sut = new Day09(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedNumber, sut.getFirstNonMatchingNumber(preambelLength));
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    public void testCalculateSumsPart2(final String input, final int preambelLength, final int expectedNumber) {
        final Day09 sut = new Day09(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedNumber, sut.getSumForPart2(preambelLength));
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 5, 127),
            Arguments.of(inputReal, 25, 26134589)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        return Stream.of(
            Arguments.of(inputDummy, 5, 62),
            Arguments.of(inputReal, 25, 3535124)
        );
    }
}
