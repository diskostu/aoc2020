package de.diskostu.day07;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 07")
class Day07Test {

    private static String inputDummy;
    private static String inputDummy2;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // sum: 7 (slighty differs from website; I adjusted "dotted black bags" which can now contain a shiny gold bag.
        inputDummy = """
            light red bags contain 1 bright white bag, 2 muted yellow bags.
            dark orange bags contain 3 bright white bags, 4 muted yellow bags.
            bright white bags contain 1 shiny gold bag.
            muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags, 4 dotted black bags.
            vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain 1 shiny gold bag.
            """;

        inputReal = new InputFileSupplier("in/day07.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    public void testCalculateSumsPart1(final String input, final int expectedId) {
        final Day07Part1 sut = new Day07Part1(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumPart1());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 7),
            Arguments.of(inputReal, 378)
        );
    }
}
