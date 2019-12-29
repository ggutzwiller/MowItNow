package com.ggutzwiller.xebia.mowitnow.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
@Data
public class Mower {
    private Position position;
    private Orientation orientation;
    private List<Instruction> instructions;

    public Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
        this.instructions = new ArrayList<>();
    }

    public void moveForward() {
        position.setX(position.getX() + orientation.x);
        position.setY(position.getY() + orientation.y);
    }

    public void turnLeft() {
        orientation = orientation.left();
    }

    public void turnRight() {
        orientation = orientation.right();
    }

    public String toString() {
        return position.getX() + " " + position.getY() + " " + orientation.label;
    }
}
