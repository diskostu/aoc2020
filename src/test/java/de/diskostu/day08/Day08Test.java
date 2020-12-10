package de.diskostu.day08;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 08")
class Day08Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // part 1: 5
        // part 1: 8
        inputDummy = """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
            """;

        inputReal = new InputFileSupplier("in/day08.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    public void testCalculateSumsPart1(final String input, final int expectedId) {
        final Day08 sut = new Day08(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumPart1());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    public void testCalculateSumsPart2(final String input, final int expectedId) {
        final Day08 sut = new Day08(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumPart2());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 5),
            Arguments.of(inputReal, 1475)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        return Stream.of(
            Arguments.of(inputDummy, 8),
            Arguments.of(inputReal, 1270)
        );
    }
}
