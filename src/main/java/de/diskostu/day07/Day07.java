package de.diskostu.day07;

import de.diskostu.util.InputSupplier;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day07 {

    private final List<String> rules;

    private final static String OUR_BAG = "shiny gold";


    public Day07(InputSupplier inputSupplier) {
        rules = inputSupplier.get()
                             .collect(Collectors.toList());
    }


    public int calculateSumPart1() {
        final Map<String, Baggage> baggageMap = createBaggageMap();

        int sum = 0;
        for (final String baggageKey : baggageMap.keySet()) {
            if (baggageKey.equals(OUR_BAG)) {
                continue;
            }
            if (canContainShinyGoldBag(baggageKey, baggageMap)) {
                sum++;
            }
        }

        return sum;
    }


    private boolean canContainShinyGoldBag(final String baggageKey, final Map<String, Baggage> baggageMap) {
        final Baggage baggage = baggageMap.get(baggageKey);

        final List<Pair<Integer, String>> canContain = baggage.getCanContain();
        if (canContain.isEmpty()) {
            return false;
        }

        for (Pair<Integer, String> integerStringPair : canContain) {
            if (integerStringPair.getRight().equals(OUR_BAG)) {
                return true;
            }
        }

        for (Pair<Integer, String> integerStringPair : canContain) {
            if (canContainShinyGoldBag(integerStringPair.getRight(), baggageMap)) {
                return true;
            }
        }

        return false;
    }


    public long calculateSumPart2() {
        // we start the counting process with the shiny gold bag
        return countNumberOfBagsWithinABag(OUR_BAG, createBaggageMap());
    }


    private long countNumberOfBagsWithinABag(final String baggageKey, final Map<String, Baggage> baggageMap) {
        final Baggage currentBaggage = baggageMap.get(baggageKey);

        final List<Pair<Integer, String>> canContain = currentBaggage.getCanContain();
        int i = 0;
        for (final Pair<Integer, String> integerStringPair : canContain) {
            final Integer left = integerStringPair.getLeft();
            final String right = integerStringPair.getRight();

            i += left + left * countNumberOfBagsWithinABag(right, baggageMap);
        }

        return i;
    }


    private Map<String, Baggage> createBaggageMap() {
        final Map<String, Baggage> baggageMap = new HashMap<>();

        for (final String rule : rules) {
            // 1) split by " contain "
            final String[] baggageKeyAndCanContain = rule.split(" contain ");

            // 2) remove "bags" from [0] and trim it
            final String baggageKey = baggageKeyAndCanContain[0].replace("bags", "").trim();
            final Baggage baggage = new Baggage(baggageKey);

            // 3) check if this bag cannot contain other bags
            if (baggageKeyAndCanContain[1].contains("no other")) {
                baggageMap.put(baggageKey, baggage);
                continue;
            }

            // 4) split [1] by ", "
            final String[] allowedBaggages = baggageKeyAndCanContain[1].split(", ");

            // 5) remove "bags", then "bag", then trim it
            for (final String allowedBaggage : allowedBaggages) {
                final String trim = allowedBaggage
                    .replace("bags", "")
                    .replace("bag", "")
                    .replace(".", "")
                    .trim();

                final String[] numberAndKey = trim.split(" ", 2);
                final ImmutablePair<Integer, String> numberAndKeyPair = new ImmutablePair<>(Integer.parseInt(numberAndKey[0]), numberAndKey[1]);
                baggage.getCanContain().add(numberAndKeyPair);
            }

            baggageMap.put(baggageKey, baggage);
        }

        return baggageMap;
    }
}
