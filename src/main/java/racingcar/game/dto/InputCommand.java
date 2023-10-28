package racingcar.game.dto;

public record InputCommand(
    String[] carNames,
    int numberOfMoves
) {

}
