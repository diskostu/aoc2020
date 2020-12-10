package de.diskostu.day08;

import de.diskostu.util.InputSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day08 {

    private final List<String> instructionsFromInput;


    public Day08(InputSupplier inputSupplier) {
        instructionsFromInput = inputSupplier.get()
                                             .collect(Collectors.toList());
    }


    public int calculateSumPart1() {
        final List<Instruction> instructions = createInstructions();
        final List<Integer> visitedInstructions = new ArrayList<>();

        int accSum = 0;
        for (int i = 0; i < instructions.size(); i += 0) {
            if (visitedInstructions.contains(i)) {
                return accSum;
            }

            visitedInstructions.add(i);

            final Instruction instruction = instructions.get(i);
            switch (instruction.getOperation()) {
                case Instruction.ACC -> {
                    accSum += instruction.getValue();
                    i++;
                }
                case Instruction.NOP -> i++;
                case Instruction.JMP -> i += instruction.getValue();
            }
        }

        return accSum;
    }


    private List<Instruction> createInstructions() {
        final List<Instruction> instructions = new ArrayList<>();

        for (final String instructionFromInput : instructionsFromInput) {
            final String[] split = instructionFromInput.split(" ");
            instructions.add(new Instruction(split[0], Integer.parseInt(split[1])));
        }

        return instructions;
    }
}
