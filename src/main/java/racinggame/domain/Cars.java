package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return findWinners(getMaxPosition());
    }

    public List<Car> findWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars)
            maxPosition = car.getMaxPosition(maxPosition);
        return maxPosition.getPosition();
    }
}
