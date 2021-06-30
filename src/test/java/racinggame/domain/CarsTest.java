package racinggame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void findWinners(){
        Car pobi = new Car("pobi", 4);
        Car crong = new Car("crong", 4);
        Car honux = new Car("honux",3);
        List<Car> ordinal = Arrays.asList(pobi, crong, honux);
        Cars cars = new Cars(ordinal);
        assertThat(cars.findWinners()).containsExactly(pobi, crong);
    }
}