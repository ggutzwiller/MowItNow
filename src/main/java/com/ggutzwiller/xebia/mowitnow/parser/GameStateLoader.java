package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.MowItNowException;
import com.ggutzwiller.xebia.mowitnow.exception.ParseException;
import com.ggutzwiller.xebia.mowitnow.model.Game;
import com.ggutzwiller.xebia.mowitnow.model.Mower;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
public class GameStateLoader {
    private final LawnParser lawnParser;
    private final MowerParser mowerParser;
    private final InstructionsParser instructionsParser;

    public GameStateLoader() {
        this.lawnParser = new LawnParser();
        this.mowerParser = new MowerParser();
        this.instructionsParser = new InstructionsParser();
    }

    public Game loadFromString(String gameRepresentation) throws MowItNowException {
        String[] splittedLines = gameRepresentation.split("\n");

        if (splittedLines.length % 2 == 0) {
            throw new ParseException("Invalid number of lines in game representation.");
        }

        Game state = new Game();
        state.setLawn(lawnParser.parse(splittedLines[0]));

        List<Mower> mowers = new ArrayList<>();
        for (int i = 1; i < splittedLines.length; i+=2) {
            Mower mower = mowerParser.parse(splittedLines[i]);
            mower.setInstructions(instructionsParser.parse(splittedLines[i + 1]));
            mowers.add(mower);
        }

        state.setMowers(mowers);

        return state;
    }

}
