package de.diskostu.day05;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day05 {

    private final List<String> seatCodes;

    private static final int ROW_MAX = 127;
    private static final int COL_MAX = 7;


    public Day05(final InputSupplier inputSupplier) {
        seatCodes = inputSupplier.get()
                                 .collect(Collectors.toList());
    }


    int findMySeat() {
        final String occupied = "X";
        final String[][] seatArray = new String[128][8];

        for (final String seatCode : seatCodes) {
            final Seat seat = calculateSeatCoordinates(seatCode);
            seatArray[seat.getRow()][seat.getColumn()] = occupied;
        }

        // we know:
        // 1) in the front and in the back, seats are not occupied
        // 2) one seat in between is not occupied
        // so we need to find the first empty seat after a bunch of occupied seats

        boolean occupiedSeatFound = false;
        for (int row = 0; row < seatArray.length; row++) {
            for (int col = 0; col < seatArray[row].length; col++) {
                final String currentSeatStatus = seatArray[row][col];
                if (occupied.equals(currentSeatStatus)) {
                    occupiedSeatFound = true;
                }
                if (occupiedSeatFound && currentSeatStatus == null) {
                    return calculateSeatId(new Seat(row, col));
                }
            }
        }

        return -1;
    }

    int calculateHighestSeatId() {
        int highestSeatId = -1;

        for (final String seatCode : seatCodes) {
            final Seat seat = calculateSeatCoordinates(seatCode);
            final int seatId = calculateSeatId(seat);
            if (seatId > highestSeatId) {
                highestSeatId = seatId;
            }
        }

        return highestSeatId;
    }


    static Seat calculateSeatCoordinates(final String seatCode) {
        return new Seat(calculateRow(seatCode), calculateColumn(seatCode));
    }


    private static int calculateRow(final String seatCode) {
        String rowCode = seatCode.substring(0, seatCode.length() - 3);
        rowCode = rowCode.replace('B', 'H');
        rowCode = rowCode.replace('F', 'L');

        return resolveInterval(rowCode, ROW_MAX);
    }


    private static int calculateColumn(final String seatCode) {
        String colCode = seatCode.substring(seatCode.length() - 3);
        colCode = colCode.replace('R', 'H');
        // we don't need to replace 'L'

        return resolveInterval(colCode, COL_MAX);
    }


    private static int resolveInterval(final String code, final int max) {
        // H = high
        // L = low
        final char[] codeChars = code.toCharArray();

        int currentMin = 0;
        int currentMax = max;
        for (final char currentChar : codeChars) {
            switch (currentChar) {
                // max changes
                case 'L' -> currentMax = currentMax - ((currentMax - currentMin + 1) / 2);
                // min changes
                case 'H' -> currentMin = currentMin + ((currentMax - currentMin - 1) / 2) + 1;
                default -> throw new IllegalStateException("unknown char: " + currentChar);
            }
        }

        if (currentMin != currentMax) {
            throw new IllegalStateException("all steps calculated, but min and max differ!");
        }

        return currentMin;
    }


    public static int calculateSeatId(final Seat seat) {
        // rule: multiply the row by 8, then add the column
        return seat.getRow() * 8 + seat.getColumn();
    }
}
