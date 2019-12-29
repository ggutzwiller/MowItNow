package com.ggutzwiller.xebia.mowitnow.serializer;

import com.ggutzwiller.xebia.mowitnow.model.Game;
import com.ggutzwiller.xebia.mowitnow.model.Mower;
import com.ggutzwiller.xebia.mowitnow.model.Orientation;
import com.ggutzwiller.xebia.mowitnow.model.Position;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
@Test
public class GameSerializerTest {

    @Test
    public void serialize_shouldSerializeWithoutError() {
        Game game = new Game();
        List<Mower> mowers = List.of(
                new Mower(
                        new Position(1, 1),
                        Orientation.NORTH
                ),
                new Mower(
                        new Position(1, 3),
                        Orientation.EAST
                )
        );
        game.setMowers(mowers);
        String expectedResult = "1 1 N\n1 3 E";

        String actualResult = GameSerializer.serialize(game);

        Assert.assertEquals(actualResult, expectedResult);
    }

}
