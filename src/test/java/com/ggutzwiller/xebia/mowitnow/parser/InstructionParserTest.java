package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.InstructionNotFoundException;
import com.ggutzwiller.xebia.mowitnow.model.Instruction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @date 29/12/2019
 */
@Test
public class InstructionParserTest {
    private InstructionsParser instructionsParser;

    @BeforeMethod
    public void setUp() {
        this.instructionsParser = new InstructionsParser();
    }

    @Test
    public void parse_validData_shouldParseWithoutError() throws InstructionNotFoundException {
        String theInstructionSet = "AGA";
        List<Instruction> expectedInstructions = List.of(
                Instruction.MOVE_FORWARD,
                Instruction.TURN_LEFT,
                Instruction.MOVE_FORWARD
        );

        List<Instruction> actualInstructions = instructionsParser.parse(theInstructionSet);

        Assert.assertEquals(actualInstructions, expectedInstructions);
    }

    @Test
    public void parse_noData_shouldReturnEmptyList() throws InstructionNotFoundException {
        String theInstructionSet = "";
        List<Instruction> expectedInstructions = new ArrayList<>();

        List<Instruction> actualInstructions = instructionsParser.parse(theInstructionSet);

        Assert.assertEquals(actualInstructions, expectedInstructions);
    }

    @Test(expectedExceptions = InstructionNotFoundException.class)
    public void parse_invalidData_shouldThrowException() throws InstructionNotFoundException {
        String theInstructionSet = "ALFA";

        List<Instruction> actualInstructions = instructionsParser.parse(theInstructionSet);
    }
}
