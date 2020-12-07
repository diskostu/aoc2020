package de.diskostu.day06;

import de.diskostu.util.InputSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Day06 {

    private final List<String> answers;


    public Day06(InputSupplier inputSupplier) {
        answers = inputSupplier.get()
                               .collect(Collectors.toList());
    }


    public long calculateSums() {
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


    private Set<Character> createUniqueCharSetFromString(final String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(TreeSet::new));
    }


    long getSum(List<Set<Character>> uniqueAnswers) {
        int sum = 0;

        for (Set<Character> uniqueAnswer : uniqueAnswers) {
            sum += uniqueAnswer.size();
        }

        return sum;
    }
}
