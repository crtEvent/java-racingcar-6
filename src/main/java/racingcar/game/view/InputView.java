package racingcar.game.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.dto.InputCommand;

public class InputView {

    public InputCommand inputCommand() {
        System.out.println("[🚖🚘 레이싱 게임 🚘🚖]");

        return new InputCommand(
            inputCarNames(),
            inputNumberOfMoves()
        );
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차들의 이름을 입력해 주세요.");
        System.out.println("\t- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.");

        return convertCarNames(Console.readLine());
    }

    private String[] convertCarNames(String command) {
        String[] carNames = command.split(",");
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("이름은 1글자 이상, 5자 이하만 가능합니다.");
            }
        }

        return carNames;
    }

    private int inputNumberOfMoves() {
        System.out.println("이동할 횟수를 입력해 주세요.");
        System.out.println("\t- 이동할 횟수는 1~10까지 입력 가능합니다.");

        return convertNumberOfMoves(Console.readLine());
    }

    private int convertNumberOfMoves(String command) {
        int numOfMoves;
        try {
            numOfMoves = Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동할 횟수는 1~10까지 입력 가능합니다.");
        }

        if (numOfMoves < 1 || numOfMoves > 10) {
            throw new IllegalArgumentException("이동할 횟수는 1~10까지 입력 가능합니다.");
        }

        return numOfMoves;
    }


}
