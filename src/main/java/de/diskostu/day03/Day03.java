package de.diskostu.day03;

import de.diskostu.util.InputSupplier;

import java.util.List;
import java.util.stream.Collectors;

public class Day03 {

    private final List<String> rows;

    private final static char TREE = '#';
    private final static int MOVE_X = 3;




    public Day03(InputSupplier inputSupplier) {
        rows = inputSupplier.get()
                            .collect(Collectors.toList());
    }


    public long getTreeCount() {
        int treeCount = 0;
        int xPos = 0;
        final int rowLength = rows.get(0).length();

        for (final String row : rows) {
            if (row.charAt(xPos) == TREE) {
                treeCount++;
            }

            xPos += MOVE_X;
            if (xPos > (rowLength - 1)) {
                xPos = xPos - rowLength;
            }
        }

        return treeCount;
    }
}
