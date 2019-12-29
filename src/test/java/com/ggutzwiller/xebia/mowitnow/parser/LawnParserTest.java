package com.ggutzwiller.xebia.mowitnow.parser;

import com.ggutzwiller.xebia.mowitnow.exception.ParseException;
import com.ggutzwiller.xebia.mowitnow.model.Lawn;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Grégoire Gutzwiller
 * @date 29/12/2019
 */
@Test
public class LawnParserTest {
    private LawnParser lawnParser;

    @BeforeMethod
    public void setUp() {
        this.lawnParser = new LawnParser();
    }

    @Test
    public void parse_validData_shouldParseWithoutError() throws ParseException {
        String lawnRepresentation = "5 5";
        Lawn expectedLawn = new Lawn(6, 6);

        Lawn actualLawn = lawnParser.parse(lawnRepresentation);

        Assert.assertEquals(actualLawn.getHeight(), expectedLawn.getHeight());
        Assert.assertEquals(actualLawn.getWidth(), expectedLawn.getWidth());
    }

    @Test(expectedExceptions = ParseException.class)
    public void parse_invalidData_shouldThrowParseException() throws ParseException {
        String lawnRepresentation = "5 2 3";

        Lawn actualLawn = lawnParser.parse(lawnRepresentation);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void parse_invalidData_shouldThrowNumberFormatException() throws ParseException {
        String lawnRepresentation = "5 N";

        Lawn actualLawn = lawnParser.parse(lawnRepresentation);
    }

}
