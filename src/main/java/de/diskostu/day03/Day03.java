package de.diskostu.day03;

import de.diskostu.util.InputSupplier;

import java.util.List;
import java.util.stream.Collectors;

public class Day03 {

    private final List<String> rows;

    private final static char TREE = '#';


    public Day03(InputSupplier inputSupplier) {
        rows = inputSupplier.get()
                            .collect(Collectors.toList());
    }


    public long getTreeCount(int moveX, int moveY) {
        int treeCount = 0;
        int xPos = 0;
        final int rowLength = rows.get(0).length();

        for (int i = 0; i < rows.size(); i += moveY) {
            if (rows.get(i).charAt(xPos) == TREE) {
                treeCount++;
            }

            xPos += moveX;
            if (xPos > (rowLength - 1)) {
                xPos = xPos - rowLength;
            }
        }

        return treeCount;
    }


    public long getResultForMultipleSlopes(List<int[]> slopeMoves) {
        long result = 0;

        for (int[] slopeMove : slopeMoves) {
            final int moveX = slopeMove[0];
            final int moveY = slopeMove[1];
            final long treeCount = getTreeCount(moveX, moveY);

            result = result == 0 ? treeCount : result * treeCount;
        }

        return result;
    }
}
