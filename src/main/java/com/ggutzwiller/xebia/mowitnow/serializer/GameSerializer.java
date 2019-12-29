package com.ggutzwiller.xebia.mowitnow.serializer;

import com.ggutzwiller.xebia.mowitnow.model.Game;

import java.util.StringJoiner;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
public class GameSerializer {
    public static String serialize(Game game) {
        StringJoiner joiner = new StringJoiner("\n");

        game.getMowers().forEach(m -> joiner.add(m.toString()));

        return joiner.toString();
    }
}
