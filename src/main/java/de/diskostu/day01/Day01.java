package de.diskostu.day01;

import de.diskostu.util.InputSupplier;

import java.util.List;
import java.util.stream.Collectors;

public class Day01 {

    final static long EXPECTED_RESULT = 2020;

    private final List<Long> numbers;


    public Day01(InputSupplier inputSupplier) {
        numbers = inputSupplier.get()
                               .map(Long::parseLong)
                               .collect(Collectors.toList());
    }


    public long solution2() {
        for (Long a : numbers) {
            for (Long b : numbers) {
                if (a + b == EXPECTED_RESULT) {
                    return a * b;
                }
            }
        }

        return 0;
    }


    public long solution3() {
        for (Long a : numbers) {
            for (Long b : numbers) {
                for (Long c : numbers) {
                    if (a + b + c == EXPECTED_RESULT) {
                        return a * b * c;
                    }
                }
            }
        }

        return 0;
    }
}
