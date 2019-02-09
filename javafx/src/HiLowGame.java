import java.util.Random;

public class HiLowGame {

    private static final int UPPER_RANGE = 100;

    private int targetNumber;

    private GuessStatus status = GuessStatus.NOT_STARTED;

    public enum GuessStatus {
        NOT_STARTED, TOO_HIGH, TOO_LOW, CORRECT
    }

    public HiLowGame() {
        restart();
    }

    public void restart() {
        targetNumber = new Random().nextInt(UPPER_RANGE) + 1;
        status = GuessStatus.NOT_STARTED;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public GuessStatus guess(int inputNumber) {

        if (targetNumber == inputNumber) {
            status = GuessStatus.CORRECT;
        } else if (targetNumber < inputNumber) {
            status = GuessStatus.TOO_HIGH;
        } else {
            status = GuessStatus.TOO_LOW;
        }

        return status;

    }

    public GuessStatus getStatus() {
        return status;
    }


}
