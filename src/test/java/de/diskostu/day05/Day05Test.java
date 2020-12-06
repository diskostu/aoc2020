package de.diskostu.day05;

import de.diskostu.util.InputFileSupplier;
import de.diskostu.util.InputSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Day 05")
class Day05Test {

    private static String inputDummy;
    private static String inputReal;


    @BeforeAll
    private static void init() {
        // FBFBBFFRLR id: 357
        // BFBFBFBLRL id: 682
        inputDummy = """
            FBFBBFFRLR
            BFBFBFBLRL
            """;

        inputReal = new InputFileSupplier("in/day05.txt").get();
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultHighestSeatId")
    public void testCalculateHighestSeatId(final String input, final int expectedId) {
        final Day05 sut = new Day05(new InputSupplier(() -> input));

        Assertions.assertEquals(expectedId, sut.calculateHighestSeatId());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultSeatCoordinates")
    public void testCalculateSeatCoordinates(final String seatCode, final int expectedRow, final int expectedColumn) {
        final Seat calculatedSeat = Day05.calculateSeatCoordinates(seatCode);

        Assertions.assertEquals(expectedRow, calculatedSeat.getRow());
        Assertions.assertEquals(expectedColumn, calculatedSeat.getColumn());
    }


    @ParameterizedTest
    @MethodSource("provideInputAndExpectedResultSeatId")
    public void testCalculateSeatId(final int row, final int column, final int expectedSeatId) {
        final int calculatedSeatId = Day05.calculateSeatId(new Seat(row, column));
        Assertions.assertEquals(expectedSeatId, calculatedSeatId);
    }


    private static Stream<Arguments> provideInputAndExpectedResultHighestSeatId() {
        return Stream.of(
            Arguments.of(inputDummy, 682),
            Arguments.of(inputReal, 858)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultSeatCoordinates() {
        return Stream.of(
            Arguments.of("FBFBBFFRLR", 44, 5),
            Arguments.of("BFBFBFBLRL", 85, 2)
        );
    }


    private static Stream<Arguments> provideInputAndExpectedResultSeatId() {
        return Stream.of(
            Arguments.of(44, 5, 357),
            Arguments.of(85, 2, 682)
        );
    }
}
