package racingcar;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private String name;
    public CarName(String name){
        if(name.length()>MAX_LENGTH)
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
