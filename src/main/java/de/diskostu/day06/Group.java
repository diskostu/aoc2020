package de.diskostu.day06;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Group {

    /**
     * represents the answers of a group of people.
     */
    private final List<Set<Character>> answers;
}
