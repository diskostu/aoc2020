package de.diskostu.day03;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 03")
class Day03Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // 7 trees
        inputDummy = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
            """;

        // 232 trees
        inputReal = new InputFileSupplier("in/day03.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    void testPasswordRulesPart1(String input, long expectedResult) {
        final Day03 sut = new Day03(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getTreeCount());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 7),
            Arguments.of(inputReal, 232)
        );
    }
}
