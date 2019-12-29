package com.ggutzwiller.xebia.mowitnow;

import com.ggutzwiller.xebia.mowitnow.exception.MowItNowException;
import com.ggutzwiller.xebia.mowitnow.model.Game;
import com.ggutzwiller.xebia.mowitnow.parser.GameStateLoader;
import com.ggutzwiller.xebia.mowitnow.serializer.GameSerializer;
import com.ggutzwiller.xebia.mowitnow.solver.GameSolver;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Grégoire Gutzwiller
 * @since 22/12/2019
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        /* TODO : This is left unimplemented because the execution will be performed from the unit tests.
        *   However, it is supposed to be implemented to read a file, and manage exceptions. */
        throw new UnsupportedOperationException("No main method, please run it from unit tests.");
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
        return GameSerializer.serialize(game);
    }
}
