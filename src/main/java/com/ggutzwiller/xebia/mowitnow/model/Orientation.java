package com.ggutzwiller.xebia.mowitnow.model;

import com.ggutzwiller.xebia.mowitnow.exception.OrientationNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
@Slf4j
@AllArgsConstructor
public enum Orientation {
    NORTH("N", 0, 1, "W", "E"),
    EAST("E", 1, 0, "N", "S"),
    WEST("W", -1, 0, "S", "N"),
    SOUTH("S", 0, -1, "E", "W");

    public String label;
    public int forwardX;
    public int forwardY;
    public String left;
    public String right;

    public Orientation right() {
        try {
            return byLabel(this.right);
        } catch (OrientationNotFoundException e) {
            /* This is not supposed to happen */
            log.error("It was not possible to get right Orientation of {}", this.label);
            return NORTH;
        }
    }

    public Orientation left() {
        try {
            return byLabel(this.left);
        } catch (OrientationNotFoundException e) {
            /* This is not supposed to happen */
            log.error("It was not possible to get left Orientation of {}", this.label);
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
