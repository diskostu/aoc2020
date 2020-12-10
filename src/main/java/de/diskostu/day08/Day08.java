package de.diskostu.day08;

import de.diskostu.util.InputSupplier;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class Day08 {

    private final List<String> instructionsFromInput;


    public Day08(InputSupplier inputSupplier) {
        instructionsFromInput = inputSupplier.get()
                                             .collect(Collectors.toList());
    }


    public int calculateSumPart1() {
        try {
            return getSumOfInstructions(createInstructions(), false);
        } catch (InstructionAlreadyVisitedException e) {
            throw new IllegalStateException("should not happen here");
        }
    }


    public int calculateSumPart2() {
        final List<Instruction> instructions = createInstructions();

        for (int i = 0; i < instructions.size(); i++) {
            final Instruction instruction = instructions.get(i);
            final String currentOperation = instruction.getOperation();

            if (currentOperation.equals(Instruction.ACC)) {
                continue;
            }

            log.info("changing index " + i + " (current operation is " + currentOperation + ")");
            String operationTo = null;
            switch (currentOperation) {
                case Instruction.NOP -> operationTo = Instruction.JMP;
                case Instruction.JMP -> operationTo = Instruction.NOP;
            }

            instruction.setOperation(operationTo);
            try {
                return getSumOfInstructions(instructions, true);
            } catch (InstructionAlreadyVisitedException e) {
                log.warn("Naa... :(");
                instruction.setOperation(currentOperation);
            }
        }

        throw new IllegalStateException("No valid result found");
    }


    public int getSumOfInstructions(List<Instruction> instructions, boolean isThrowIfError) throws InstructionAlreadyVisitedException {
        final List<Integer> visitedInstructions = new ArrayList<>();

        int accSum = 0;
        for (int i = 0; i < instructions.size(); i += 0) {
            if (visitedInstructions.contains(i)) {
                if (isThrowIfError) {
                    throw new InstructionAlreadyVisitedException();
                } else {
                    return accSum;
                }
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

        log.info("Yeeha! Sum is " + accSum);

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
