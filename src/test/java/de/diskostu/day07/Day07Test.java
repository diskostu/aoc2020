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

    private static String inputDummyPart1;
    private static String inputDummy1Part2;
    private static String inputDummy2Part2;
    private static String inputDummy3Part2;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // part 1: 7
        // part 2: 32
        inputDummyPart1 = """
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
        // part 2: 18
        inputDummy1Part2 = """
            shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
            dark olive bags contain 3 faded blue bags.
            vibrant plum bags contain 6 dotted black bags.
            faded blue bags contain no other bags.
            dotted black bags contain no other bags.
            """;
        // part 2: 126
        inputDummy2Part2 = """
            shiny gold bags contain 2 dark red bags.
            dark red bags contain 2 dark orange bags.
            dark orange bags contain 2 dark yellow bags.
            dark yellow bags contain 2 dark green bags.
            dark green bags contain 2 dark blue bags.
            dark blue bags contain 2 dark violet bags.
            dark violet bags contain no other bags.
            """;
        inputDummy3Part2 = """
            shiny gold bags contain 1 dark olive bag.
            dark olive bags contain 3 faded blue bags.
            faded blue bags contain 2 vibrant plum bags, 1 dotted black bag.
            vibrant plum bags contain 6 dotted black bags.
            dotted black bags contain no other bags.
            """;

        inputReal = new InputFileSupplier("in/day07.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    public void testCalculateSumsPart1(final String input, final int expectedId) {
        final Day07 sut = new Day07(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumPart1());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    public void testCalculateSumsPart2(final String input, final int expectedId) {
        final Day07 sut = new Day07(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumPart2());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummyPart1, 7),
            Arguments.of(inputReal, 378)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        return Stream.of(
            Arguments.of(inputDummy1Part2, 18),
            Arguments.of(inputDummy2Part2, 126),
            Arguments.of(inputDummy3Part2, 49),
            Arguments.of(inputReal, 27526)
        );
    }
}
