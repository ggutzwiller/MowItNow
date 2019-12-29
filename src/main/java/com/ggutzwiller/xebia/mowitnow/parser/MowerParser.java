package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.OrientationNotFoundException;
import com.ggutzwiller.xebia.mowitnow.exception.ParseException;
import com.ggutzwiller.xebia.mowitnow.model.Mower;
import com.ggutzwiller.xebia.mowitnow.model.Orientation;
import com.ggutzwiller.xebia.mowitnow.model.Position;

import java.util.Arrays;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
public class MowerParser implements Parser<Mower> {
    @Override
    public Mower parse(String mowerRepresentation) throws OrientationNotFoundException, ParseException {
        String[] representationSplit = mowerRepresentation.split(" ");

        if (representationSplit.length != 3) {
            throw new ParseException("Mower representation " + Arrays.toString(representationSplit) + " is incorrect.");
        }

        return new Mower(
                new Position(
                        Integer.parseInt(representationSplit[0]),
                        Integer.parseInt(representationSplit[1])
                ),
                Orientation.byLabel(representationSplit[2])
        );
    }
}
