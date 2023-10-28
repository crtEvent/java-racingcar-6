package racingcar.game.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.game.domain.Car;
import racingcar.game.domain.GameSnapshot;
import racingcar.game.dto.GameResult;
import racingcar.game.dto.InputCommand;

public class GameService {

    private final GameSnapshot gameSnapshot = new GameSnapshot();

    public GameService() {}

    public GameResult start(InputCommand inputCommand) {

        List<Car> cars = generateCars(inputCommand.carNames());

        race(cars, inputCommand.numberOfMoves());

        return calculateResult(cars);
    }

    private List<Car> generateCars(String[] carNames) {
        return Arrays
            .stream(carNames)
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void race(List<Car> cars, int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            moveAllCarsOneStep(cars);
        }
    }

    private void moveAllCarsOneStep(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.moveForward();
            }
        }
        gameSnapshot.addSnapshot(cars);
    }

    private GameResult calculateResult(List<Car> cars) {
        int farthestDistance
            = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        List<String> winnersNames
            = cars.stream()
            .filter(car -> car.getPosition() == farthestDistance)
            .map(Car::getName)
            .toList();

        return new GameResult(winnersNames, gameSnapshot);
    }

}
