package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.ParseException;
import com.ggutzwiller.xebia.mowitnow.model.Lawn;

import java.util.Arrays;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
public class LawnParser implements Parser<Lawn> {
    @Override
    public Lawn parse(String lawnRepresentation) throws ParseException {
        String[] representationSplit = lawnRepresentation.split(" ");

        if (representationSplit.length != 2) {
            throw new ParseException("Lawn representation " + Arrays.toString(representationSplit) + " is incorrect.");
        }

        return new Lawn(
                Integer.parseInt(representationSplit[0]) + 1,
                Integer.parseInt(representationSplit[1]) + 1
        );
    }
}
