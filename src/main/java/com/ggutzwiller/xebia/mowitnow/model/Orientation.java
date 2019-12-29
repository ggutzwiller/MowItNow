package com.ggutzwiller.xebia.mowitnow.model;

import com.ggutzwiller.xebia.mowitnow.exception.OrientationNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
@AllArgsConstructor
public enum Orientation {
    NORTH("N", 0, 1),
    EAST("E", 1, 0),
    WEST("W", -1, 0),
    SOUTH("S", 0, -1);

    private String label;
    public int x;
    public int y;

    public Orientation right() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
            default:
                return NORTH;
        }
    }

    public Orientation left() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
            default:
                return NORTH;
        }
    }

    /**
     * Returns an orientation based on a label
     * @param label either N, E, W, S
     * @return the proper Orientation
     * @throws OrientationNotFoundException if no Orientation can be found (ie. you pass something else than N,E,W,S)
     */
    public static Orientation byLabel(String label) throws OrientationNotFoundException {
        return Arrays.stream(values())
                .filter(v -> v.label.equals(label))
                .findFirst()
                .orElseThrow(() -> new OrientationNotFoundException("Cannot find a valid orientation for label " + label));
    }
}
