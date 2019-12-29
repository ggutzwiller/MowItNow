package com.ggutzwiller.xebia.mowitnow;

import com.ggutzwiller.xebia.mowitnow.exception.MowItNowException;
import com.ggutzwiller.xebia.mowitnow.model.Game;
import com.ggutzwiller.xebia.mowitnow.parser.GameStateLoader;
import com.ggutzwiller.xebia.mowitnow.solver.GameSolver;

/**
 * @author Grégoire Gutzwiller
 * @since 22/12/2019
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * This method runs the program, ie. takes a string representing
     * the instructions and returns the solution.
     *
     * @param inputInstructions the instructions as a string
     * @return the solution in a string
     */
    public static String run(String inputInstructions) throws MowItNowException {
        Game game = new GameStateLoader().loadFromString(inputInstructions);
        new GameSolver(game).solve();

        return "";
    }
}
