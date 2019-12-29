package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.InstructionNotFoundException;
import com.ggutzwiller.xebia.mowitnow.model.Instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
public class InstructionsParser implements Parser<List<Instruction>>{
    @Override
    public List<Instruction> parse(String stringRepresentation) throws InstructionNotFoundException {
        List<Instruction> instructions = new ArrayList<>();

        if (stringRepresentation.length() == 0) {
            return instructions;
        }

        for (String charInstruction : stringRepresentation.split("")) {
            instructions.add(Instruction.byLabel(charInstruction));
        }

        return instructions;
    }
}
