package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> names) {
        cars = mapCar(names);
    }

    public static List<Car> mapCar(List<String> names) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < names.size(); i++)
            list.add(new Car(names.get(i), 1));
        return list;
    }

    public List<String> whoIsWinner(int count) {
        start();
        for (int i = 0; i < count; i++) racing();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            String winner = car.isWinner(cars);
            if (winner != null) winners.add(winner);
        }
        return winners;
    }

    public void start(){
        for(Car car : cars){
            car.print();
        }
        System.out.println();
    }

    public void racing() {
        for (Car car : cars) {
            car.racing();
            car.print();
        }
        System.out.println();
    }
}
