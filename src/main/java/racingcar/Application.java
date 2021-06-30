package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String cars = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();
        System.out.println("실행 결과");
        RacingCars racingCars = new RacingCars(Arrays.asList(cars.split(",")));
        List<String> winners = racingCars.whoIsWinner(count);
        for(int i=0; i<winners.size(); i++){
            if(i!=0) System.out.print(",");
            System.out.print(winners.get(i));
        }

        System.out.print("가 최종 우승했습니다.");
    }
}
