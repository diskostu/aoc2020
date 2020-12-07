package de.diskostu.day06;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@DisplayName("Day 06")
class Day06Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // sum: 11
        inputDummy = """
            abc

            a
            b
            c

            ab
            ac

            a
            a
            a
            a

            b
            """;

        inputReal = new InputFileSupplier("in/day06.txt").get();
    }


    @Test
    public void testMethod() {
        final Day06 sut = new Day06(new InputSupplier(() -> inputDummy));

        final List<Set<Character>> sets = sut.collectUniqueGroupAnswers();

        System.out.println("strings = " + sets);

    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResult")
    public void testCalculateSums(final String input, final int expectedId) {
        final Day06 sut = new Day06(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSums());
    }


    private static Stream<Arguments> provideInputAndExpectedResult() {
        return Stream.of(
            Arguments.of(inputDummy, 11),
            Arguments.of(inputReal, -1)
        );
    }
}
