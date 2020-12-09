package de.diskostu.day07;

import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

@Data
public class Baggage {

    private final String key;
    private List<Pair<Integer, String>> canContain = new ArrayList<>();

    public boolean isEmpty() {
        return canContain.isEmpty();
    }
}
