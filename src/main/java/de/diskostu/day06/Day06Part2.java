package de.diskostu.day06;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
public class Day06Part2 extends Day06Abstract{

    private final List<String> allAnswers;


    public Day06Part2(InputSupplier inputSupplier) {
        allAnswers = inputSupplier.get()
                                  .collect(Collectors.toList());
    }


    public int calculateSumsPart2() {
        int sum = 0;

        final List<Group> groups = collectUniqueGroupAnswers();
        for (final Group group : groups) {
            sum += getUniqueCharCountFromSets(group.getAnswers());
        }

        return sum;
    }

    List<Group> collectUniqueGroupAnswers() {
        final List<Group> groups = new ArrayList<>();

        Group group = new Group(new ArrayList<>());
        for (final String answersFromOnePerson : allAnswers) {
            if (answersFromOnePerson.isBlank()) {
                // group finished
                groups.add(group);
                // important - create a new object
                group = new Group(new ArrayList<>());
            } else {
                group.getAnswers().add(createUniqueCharSetFromString(answersFromOnePerson));
            }
        }

        // don't forget the last one
        if (!group.getAnswers().isEmpty()) {
            groups.add(group);
        }

        return groups;
    }



    static int getUniqueCharCountFromSets(final List<Set<Character>> aList) {
        int sum = 0;

        // we only need to check every char of the first set against the others, since ALL chars have to be present
        final Set<Character> charSet1 = aList.get(0);

        // if there is only 1 member in the group, return it's answer count
        if (aList.size() == 1) {
            return charSet1.size();
        }

        for (final Character characterPerson1 : charSet1) {
            boolean allMatch = true;
            for (final Set<Character> answersFromAnotherPerson : aList) {
                if (!answersFromAnotherPerson.contains(characterPerson1)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                sum++;
            }
        }

        return sum;
    }
}
