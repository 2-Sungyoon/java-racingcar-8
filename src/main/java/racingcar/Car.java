package racingcar;

final class Car {
    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    static Car of(String name) {
        return new Car(name, 0);
    }

    void moveIf(int number) {
        if (number >= 4) {
            position++;
        }
    }

    String name() {
        return name;
    }

    int position() {
        return position;
    }
}
