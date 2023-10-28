package racingcar.game.domain;

public class Car {
    private static final String PROGRESS_BAR = "-";

    private final String name;
    private int position = 0;
    private boolean winFlag = false;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.position++;
    }

    public void win() {
        winFlag = true;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinFlag() {
        return winFlag;
    }

    public String getProgressBar() {
        return PROGRESS_BAR.repeat(position);
    }
}
