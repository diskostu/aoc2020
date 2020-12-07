package de.diskostu.day07;

import lombok.Data;

import java.util.List;

@Data
public class Baggage {

    private final String key;
    private final List<String> canContain;
}
