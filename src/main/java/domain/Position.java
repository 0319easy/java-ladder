package domain;

import java.util.Objects;

public class Position {

    private final int index;

    private Position(int index) {
        this.index = index;
    }

    static Position from(int index) {
        return new Position(index);
    }

    Position next() {
        return new Position(index + 1);
    }

    Position prev() {
        return new Position(index - 1);
    }

    int value() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return index == position.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}