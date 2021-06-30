package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차이름짓기(){
        assertThatThrownBy(() -> new CarName("5글자이상!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Car생성(){
        assertThatThrownBy(() -> new Car("5글자이상!",0))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 레이싱(){
        Car car = new Car("car1", 1);
        car.racing();
        car.print();
        Car car2 = new Car("car2", 1);
        car2.racing();
        car2.print();
        Car car3 = new Car("car3", 1);
        car3.racing();
        car3.print();
    }
}