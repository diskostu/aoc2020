package de.diskostu.day06;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
public class Day06Part1 extends Day06Abstract {

    private final List<String> answers;


    public Day06Part1(InputSupplier inputSupplier) {
        answers = inputSupplier.get()
                               .collect(Collectors.toList());
    }


    public long calculateSumsPart1() {
        return getSum(collectUniqueGroupAnswers());
    }


    @SuppressWarnings("StringConcatenationInLoop")
    List<Set<Character>> collectUniqueGroupAnswers() {
        final List<Set<Character>> uniqueAnswers = new ArrayList<>();

        String groupAnswer = "";
        for (final String row : answers) {
            if (row.isBlank()) {
                // group finished
                uniqueAnswers.add(createUniqueCharSetFromString(groupAnswer));
                groupAnswer = "";
            } else {
                groupAnswer += row;
            }
        }

        // don't forget the last one
        if (!groupAnswer.isBlank()) {
            uniqueAnswers.add(createUniqueCharSetFromString(groupAnswer));
        }

        return uniqueAnswers;
    }


    long getSum(List<Set<Character>> uniqueAnswers) {
        return uniqueAnswers.stream().mapToInt(p -> p.size()).sum();
    }
}
