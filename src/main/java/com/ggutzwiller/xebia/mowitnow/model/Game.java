package com.ggutzwiller.xebia.mowitnow.model;

import lombok.Data;

import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 29/12/2019
 */
@Data
public class Game {
    private Lawn lawn;
    private List<Mower> mowers;
}
