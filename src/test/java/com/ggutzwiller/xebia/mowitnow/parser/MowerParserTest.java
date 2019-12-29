package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.MowItNowException;
import com.ggutzwiller.xebia.mowitnow.exception.OrientationNotFoundException;
import com.ggutzwiller.xebia.mowitnow.exception.ParseException;
import com.ggutzwiller.xebia.mowitnow.model.Mower;
import com.ggutzwiller.xebia.mowitnow.model.Orientation;
import com.ggutzwiller.xebia.mowitnow.model.Position;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
@Test
public class MowerParserTest {
    private MowerParser mowerParser;

    @BeforeMethod
    public void setUp() {
        this.mowerParser = new MowerParser();
    }

    @Test
    public void parse_validData_shouldParseWithoutError() throws MowItNowException {
        String mowerRepresentation = "1 2 N";
        Mower expectedMowed = new Mower(
            new Position(1, 2),
            Orientation.NORTH
        );

        Mower actualMower = mowerParser.parse(mowerRepresentation);

        Assert.assertEquals(actualMower.getPosition().getX(), expectedMowed.getPosition().getX());
        Assert.assertEquals(actualMower.getPosition().getY(), expectedMowed.getPosition().getY());
        Assert.assertEquals(actualMower.getOrientation(), expectedMowed.getOrientation());
    }

    @Test(expectedExceptions = ParseException.class)
    public void parse_invalidData_shouldThrowParseException() throws MowItNowException {
        String mowerRepresentation = "1 1";

        Mower actualMower = mowerParser.parse(mowerRepresentation);
    }

    @Test(expectedExceptions = OrientationNotFoundException.class)
    public void parse_invalidData_shouldThrowOrientationNotFoundException() throws MowItNowException {
        String mowerRepresentation = "1 1 B";

        Mower actualMower = mowerParser.parse(mowerRepresentation);
    }
}
