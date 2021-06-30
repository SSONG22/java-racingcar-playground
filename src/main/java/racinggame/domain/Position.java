package racinggame.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(position + 1); // 불변객체
    }

    public Position move2() {
        position = position + 1;
        return this; // 가변객체
    }

    public boolean isSame(int maxPosition) {
        return this.position == maxPosition;
    }

    public boolean lessThan(Position maxPosition) {
        return this.getPosition() < maxPosition.getPosition();
    }
}
