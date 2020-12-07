package de.diskostu.day06;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Day06Abstract {

    protected static Set<Character> createUniqueCharSetFromString(final String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
