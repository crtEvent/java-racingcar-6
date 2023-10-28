package racingcar.game.view;

import racingcar.game.dto.GameResult;

public class OutputVIew {

    public void printGameResult(GameResult gameResult) throws InterruptedException {
        System.out.println("[경기를 시작합니다.]");
        for (String snapshot : gameResult.getGameSnapshots()) {
            System.out.println(snapshot);
            Thread.sleep(1000);
        }

        System.out.println("[우승자]");
        System.out.println(String.join(", ", gameResult.getWinnersNames()));
    }
}
