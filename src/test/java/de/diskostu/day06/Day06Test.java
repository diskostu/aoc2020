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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart1")
    public void testCalculateSumsPart1(final String input, final int expectedId) {
        final Day06Part1 sut = new Day06Part1(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumsPart1());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultPart2")
    public void testCalculateSumsPart2(final String input, final int expectedId) {
        final Day06Part2 sut = new Day06Part2(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateSumsPart2());
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart1() {
        return Stream.of(
            Arguments.of(inputDummy, 11),
            Arguments.of(inputReal, 7128)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultPart2() {
        return Stream.of(
            Arguments.of(inputDummy, 6),
            Arguments.of(inputReal, 3640)
        );
    }


    @Test
    public void testGetUniqueCharCountFromSets() {
        // arrange
        final TreeSet<Character> person1 = new TreeSet<>(Arrays.asList('a', 'b', 'z'));
        final TreeSet<Character> person2 = new TreeSet<>(Arrays.asList('a', 'b', 'c', 'z'));
        final TreeSet<Character> person3 = new TreeSet<>(Arrays.asList('a', 'b', 'd', 'z'));
        final TreeSet<Character> person4 = new TreeSet<>(Arrays.asList('b', 'c', 'd', 'z'));
        final TreeSet<Character> person5 = new TreeSet<>(Arrays.asList('a', 'b', 'd', 'z'));

        final List<Set<Character>> aList = new ArrayList<>(List.of(person1, person2, person3, person4, person5));

        // act
        final int uniqueCharCountFromSets = Day06Part2.getUniqueCharCountFromSets(aList);

        // assert
        // every person has marked 'b' and 'z' --> 2 matches
        Assertions.assertEquals(2, uniqueCharCountFromSets);
    }
}
