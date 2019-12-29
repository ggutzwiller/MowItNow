package com.ggutzwiller.xebia.mowitnow.model;

import com.ggutzwiller.xebia.mowitnow.exception.InstructionNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
@AllArgsConstructor
public enum Instruction {
    MOVE_FORWARD("A"),
    TURN_RIGHT("D"),
    TURN_LEFT("G");

    private String label;

    /**
     * Returns an instruction based on a label
     * @param label either A, G, D
     * @return the proper Instruction
     * @throws InstructionNotFoundException if no Instruction can be found (ie. you pass something else than A,G,D)
     */
    public static Instruction byLabel(String label) throws InstructionNotFoundException {
        return Arrays.stream(values())
                .filter(v -> v.label.equals(label))
                .findFirst()
                .orElseThrow(() -> new InstructionNotFoundException("Cannot find a valid instruction for label " + label));
    }
}
