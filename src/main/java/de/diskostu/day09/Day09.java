package de.diskostu.day09;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Log4j2
public class Day09 {

    private final List<String> numbers;


    public Day09(InputSupplier inputSupplier) {
        numbers = inputSupplier.get()
                               .collect(Collectors.toList());
    }


    public long getFirstNonMatchingNumber(final int preambelLength) {
        for (int i = 0; i < numbers.size(); i++) {
            final int indexAfterPreambel = i + preambelLength;
            final long numberAfterPreambel = Long.parseLong(numbers.get(indexAfterPreambel));
            log.info("number at index " + indexAfterPreambel + ": " + numberAfterPreambel);

            boolean matchFound = true;
            for (int j = i; j < i + preambelLength; j++) {
                for (int k = i; k < i + preambelLength; k++) {
                    final long number1 = Long.parseLong(numbers.get(j));
                    final long number2 = Long.parseLong(numbers.get(k));
                    if (number1 == number2) {
                        continue;
                    }

                    log.debug("adding %d (index %d) and %d (index %d).".formatted(number1, j, number2, k));

                    if (number1 + number2 == numberAfterPreambel) {
                        // OK
                        log.info("Great. Numbers %d (index %d) and %d (index %d) add up to %d.".formatted(number1, j, number2, k, numberAfterPreambel));
                        matchFound = true;
                        break;
                    } else {
                        // try next pair
                        matchFound = false;
                    }
                }

                if (matchFound) {
                    break;
                }
            }

            if (!matchFound) {
                log.info("Result: " + numberAfterPreambel);
                return numberAfterPreambel;
            }
        }

        return 0;
    }


    public long getSumForPart2(final int preambelLength) {
        final long firstNonMatchingNumber = getFirstNonMatchingNumber(preambelLength);

        for (int i = 0; i < numbers.size(); i++) {
            final List<Long> contiguousNumbers = new ArrayList<>();
            final long number1 = Long.parseLong(numbers.get(i));
            contiguousNumbers.add(number1);
            log.debug("starting fresh with number %d (index %d).".formatted(number1, i));

            long sum = number1;
            for (int j = i + 1; j < numbers.size(); j++) {
                final long numberToAdd = Long.parseLong(numbers.get(j));
                contiguousNumbers.add(numberToAdd);
                log.debug("adding %d (index %d) to current sum (%d), raising the sum to %d.".formatted(numberToAdd, j, sum, sum += numberToAdd));

                if (sum == firstNonMatchingNumber) {
                    // yeeha!
                    final Long min = contiguousNumbers.stream()
                                                      .mapToLong(v -> v)
                                                      .min().orElseThrow(NoSuchElementException::new);
                    final Long max = contiguousNumbers.stream()
                                                      .mapToLong(v -> v)
                                                      .max().orElseThrow(NoSuchElementException::new);
                    return min + max;
                } else if (sum > firstNonMatchingNumber) {
                    // contiguous set not found, check the next (first) number
                    log.warn("The current sum (%d) is greater than the number we are looking for (%d)".formatted(sum, firstNonMatchingNumber));
                    break;
                }
            }
        }

        return Long.MIN_VALUE;
    }
}
