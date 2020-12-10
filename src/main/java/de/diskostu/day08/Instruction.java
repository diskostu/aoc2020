package de.diskostu.day08;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instruction {

    public static final String NOP = "nop";
    public static final String ACC = "acc";
    public static final String JMP = "jmp";

    private String operation;
    private final int value;
}
