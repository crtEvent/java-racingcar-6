package racingcar.game.dto;

import java.util.Collections;
import java.util.List;
import racingcar.game.domain.GameSnapshot;

public class GameResult {
    private final List<String> winnersNames;
    private final GameSnapshot gameSnapshots;

    public GameResult(List<String> winnersNames, GameSnapshot gameSnapshots) {
        this.winnersNames = winnersNames;
        this.gameSnapshots = gameSnapshots;
    }

    public List<String> getWinnersNames() {
        return winnersNames;
    }

    public List<String> getGameSnapshots() {
        return gameSnapshots.getSnapshots();
    }

}
