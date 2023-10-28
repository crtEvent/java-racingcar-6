package racingcar.game;

import racingcar.game.dto.GameResult;
import racingcar.game.dto.InputCommand;
import racingcar.game.service.GameService;
import racingcar.game.view.InputView;
import racingcar.game.view.OutputVIew;

public class Game {

    private static final InputView inputView = new InputView();
    private static final GameService gameService = new GameService();
    private static final OutputVIew outputVIew = new OutputVIew();

    public void run() {
        try {
            InputCommand inputCommand = inputView.inputCommand();
            GameResult gameResult = gameService.start(inputCommand);
            outputVIew.printGameResult(gameResult);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
