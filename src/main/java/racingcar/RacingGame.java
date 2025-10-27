package racingcar;

import java.util.ArrayList;
import java.util.List;

final class RacingGame {
    private final List<Car> cars;
    private final NumberPicker picker;

    private RacingGame(List<Car> cars, NumberPicker picker) {
        this.cars = cars;
        this.picker = picker;
    }

    static RacingGame fromNames(List<String> names, NumberPicker picker) {
        List<Car> list = new ArrayList<>(names.size());
        for (String n : names) {
            list.add(Car.of(n));
        }
        return new RacingGame(list, picker);
    }

    void moveOnce() {
        for (Car car : cars) {
            int number = picker.pick0to9();
            car.moveIf(number);
        }
    }

    List<Car> getCars() {
        return cars;
    }

    List<String> findWinners() {
        int max = maxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.position() == max) {
                winners.add(car.name());
            }
        }
        return winners;
    }

    private int maxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.position() > max) {
                max = car.position();
            }
        }
        return max;
    }
}
