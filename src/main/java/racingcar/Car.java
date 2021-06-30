package racingcar;
import java.util.List;
import java.util.Random;

// 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.
public class Car {
    private CarName name;
    private int location;
    private String locationLoad = "";
    private Status status;

    public Car(String name, int location) {
        this.name = new CarName(name);
        this.location = location;
        status = Status.START;
        for (int i = 0; i < location; i++) locationLoad += "-";
    }

    public void racing() {
        Random random = new Random();
        if (random.nextBoolean()) move();
    }

    // 전진한다.
    public void move() {
        this.location++;
        this.locationLoad += "-";
    }

    // 출력
    public void print() {
        System.out.println(this.name.getName()+ " : " + this.locationLoad);
    }

    public String isWinner(List<Car> cars) {
        for(Car otherCar : cars){
            if(this.location < otherCar.location) return null;
        }
        return this.name.getName();
    }

    private int getLocation() {
        return location;
    }

    public void stop(int count) {
        if (this.location == count) {
            this.status = Status.END;
        }
    }

}
