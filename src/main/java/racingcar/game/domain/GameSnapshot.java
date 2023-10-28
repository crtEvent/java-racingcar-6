package racingcar.game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameSnapshot {

    private final List<String> snapshots = new ArrayList<>();

    public void addSnapshot(List<Car> cars) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("[🛣]️ %d 초\n", snapshots.size() + 1));

        for (Car car : cars) {
            builder.append(String.format("%5s : %s\n", car.getName(), car.getProgressBar()));
        }

        snapshots.add(builder.toString());
    }

    public List<String> getSnapshots() {
        return Collections.unmodifiableList(snapshots);
    }
}
