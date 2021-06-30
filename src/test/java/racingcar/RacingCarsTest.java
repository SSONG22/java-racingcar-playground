package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RacingCarsTest {
    private RacingCars cars;
    @BeforeEach
    void Car_리스트_생성(){
        cars = new RacingCars(Arrays.asList("pobi","crong", "honux"));
    }
    @Test
    void 레이싱(){
        cars.racing();
    }

    @Test
    void 위너(){
        List<String> winner = cars.whoIsWinner(5);
        System.out.println(winner);
    }
}