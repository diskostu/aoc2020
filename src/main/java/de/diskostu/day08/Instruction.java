package de.diskostu.day08;

import lombok.Data;

@Data
public class Instruction {

    public static final String NOP = "nop";
    public static final String ACC = "acc";
    public static final String JMP = "jmp";

    private final String operation;
    private final int value;
}
