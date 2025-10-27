package racingcar;

import java.util.List;

final class Printer {
    private Printer() { }

    static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name() + " : " + "-".repeat(car.position()));
        }
    }

    static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
