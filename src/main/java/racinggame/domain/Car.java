package racinggame.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    private Position position;
    private final Name name;

    public Car(final String name) {
        this(name, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public Car(String name, int position) {
        this.name = new Name(name.trim());
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable())
            position = position.move();
    }

    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            position = position.move();
    }

    public void move() {
        if (getRandomNo() >= FORWARD_NUM)
            position = position.move();
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public Position getPosition2() {
        return this.position;
    }

    public boolean isWinner(int maxPosition) {
        return position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.lessThan(maxPosition)) return maxPosition;
        return this.position;
    }
}
