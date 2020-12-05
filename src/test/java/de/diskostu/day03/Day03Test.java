package de.diskostu.day03;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
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
    void testDay03Part1(String input, int moveX, int moveY, long expectedResult) {
        final Day03 sut = new Day03(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getTreeCount(moveX, moveY));
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    void testDay03Part2(String input, List<int[]> slopeMoves, long expectedResult) {
        final Day03 sut = new Day03(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedResult, sut.getResultForMultipleSlopes(slopeMoves));
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 3, 1, 7),
            Arguments.of(inputReal, 3, 1, 232)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        final List<int[]> slopeMoves = new ArrayList<>();
        slopeMoves.add(new int[]{1, 1});
        slopeMoves.add(new int[]{3, 1});
        slopeMoves.add(new int[]{5, 1});
        slopeMoves.add(new int[]{7, 1});
        slopeMoves.add(new int[]{1, 2});

        return Stream.of(
            Arguments.of(inputDummy, slopeMoves, 336),
            Arguments.of(inputReal, slopeMoves, 3952291680L)
        );
    }
}
