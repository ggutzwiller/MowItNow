package com.ggutzwiller.xebia.mowitnow.model;

import lombok.Getter;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
@Getter
public class Lawn {
    private int height;
    private int width;

    public Lawn(int height, int width) {
        this.height = height;
        this.width = width;
    }
}
