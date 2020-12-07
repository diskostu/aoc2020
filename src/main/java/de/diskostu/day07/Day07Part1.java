package de.diskostu.day07;

import de.diskostu.util.InputSupplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day07Part1 {

    private final List<String> rules;

    private final static String OUR_BAG = "shiny gold";


    public Day07Part1(InputSupplier inputSupplier) {
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


    private Map<String, Baggage> createBaggageMap() {
        final Map<String, Baggage> baggageMap = new HashMap<>();

        for (final String rule : rules) {
            // 1) split by " contain "
            final String[] baggageKeyAndCanContain = rule.split(" contain ");

            // 2) remove "bags" from [0] and trim it
            final String baggageKey = baggageKeyAndCanContain[0].replace("bags", "").trim();
            final Baggage baggage = new Baggage(baggageKey, new ArrayList<>());

            // 3) check if this bag cannot contain other bags
            if (baggageKeyAndCanContain[1].contains("no other")) {
                baggageMap.put(baggageKey, baggage);
                continue;
            }

            // 4) split [1] by ", "
            final String[] allowedBaggages = baggageKeyAndCanContain[1].split(", ");

            // 5) remove leading number and "bags", then trim it
            for (final String s : allowedBaggages) {
                baggage.getCanContain().add(s
                    .replaceAll("[0-9]", "")
                    .replace("bags", "")
                    .replace("bag", "")
                    .replace(".", "")
                    .trim());
            }

            baggageMap.put(baggageKey, baggage);
        }

        return baggageMap;
    }


    private boolean canContainShinyGoldBag(final String baggageKey, final Map<String, Baggage> baggageMap) {
        final Baggage baggage = baggageMap.get(baggageKey);

        final List<String> canContain = baggage.getCanContain();
        if (canContain.isEmpty()) {
            return false;
        }

        if (canContain.contains(OUR_BAG)) {
            return true;
        } else {
            for (final String innerBaggageKey : canContain) {
                if (canContainShinyGoldBag(innerBaggageKey, baggageMap)) {
                    return true;
                }
            }

            return false;
        }
    }
}
