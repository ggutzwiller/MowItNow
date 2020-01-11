package com.ggutzwiller.xebia.mowitnow.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @author Grégoire Gutzwiller
 * @since 28/12/2019
 */
@Data
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
