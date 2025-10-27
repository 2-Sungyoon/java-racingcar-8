package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();

        List<String> names = InputValidator.parseAndValidateNames(namesInput);
        int attempts = InputValidator.parseAndValidateAttempts(attemptsInput);

        RacingGame game = RacingGame.fromNames(names, new RandomNumberPicker());
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            game.moveOnce();
            Printer.printRound(game.getCars());
            System.out.println();
        }
        List<String> winners = game.findWinners();
        Printer.printWinners(winners);
    }
}
