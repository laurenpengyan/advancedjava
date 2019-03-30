import javafx.scene.shape.Line;

@FunctionalInterface
public interface DisplayLineInfo {

    public static DisplayLineInfo createDisplayLineInfo(InfoType type) {
        //  YOUR CODE HERE!
        switch (type) {
            case DISTANCE:
            case MIDPOINT:
            case VERTHORZ:
                break;
        }
        return null;

    }

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ;
    }

}
