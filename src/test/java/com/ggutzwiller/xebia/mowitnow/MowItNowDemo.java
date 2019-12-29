package com.ggutzwiller.xebia.mowitnow;

import com.ggutzwiller.xebia.mowitnow.exception.MowItNowException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Grégoire Gutzwiller
 * @since 22/12/2019
 */
@Test
public class MowItNowDemo {

    /**
     * It is used to test the solution with Xebia's example.
     */
    @Test
    public void demoXebiaExample() throws MowItNowException {
        /* Given */
        String theInstructionSet = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        String theSolution = "1 3 N\n5 1 E";

        /* When */
        String proposedSolution = Main.run(theInstructionSet);

        /* Then */
        Assert.assertEquals(proposedSolution, theSolution);
    }

    /**
     * It is used to test the solution with mowers going outside grid.
     */
    @Test
    public void demoOutsideGrid() throws MowItNowException {
        String theInstructionSet = "3 3\n1 2 N\nAGAAGAADADDA\n3 3 S\nAGAGGGGA";
        String theSolution = "1 0 E\n3 2 E";

        String proposedSolution = Main.run(theInstructionSet);
        Assert.assertEquals(proposedSolution, theSolution);
    }

    /**
     * Used to test the solution with mowers crashing.
     * We made the assumption that the behaviour will be the same as if the mower goes
     * outside of the grid.
     */
    @Test
    public void demoMowerCrash() throws MowItNowException {
        String theInstructionSet = "2 2\n1 2 S\nA\n1 0 N\nADAGAAGAGAADAGAAGAG";
        String theSolution = "1 1 S\n1 0 N";

        String proposedSolution = Main.run(theInstructionSet);
        Assert.assertEquals(proposedSolution, theSolution);
    }
}
