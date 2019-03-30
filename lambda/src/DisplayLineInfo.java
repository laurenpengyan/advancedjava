import javafx.scene.shape.Line;

@FunctionalInterface
public interface DisplayLineInfo {

    public static DisplayLineInfo createDisplayLineInfo(InfoType type) {
        //  YOUR CODE HERE!
        switch (type) {
            case DISTANCE:
                return line -> String.format("%.1f", Math.sqrt(Math.pow(line.getEndX() - line.getStartX(), 2) + Math.pow(line.getEndY() - line.getStartY(), 2)));
            case MIDPOINT:
                return line ->
                        String.format("(%.1f,%.1f)", (line.getEndX() + line.getStartX()) / 2, (line.getEndY() + line.getStartY()) / 2);
            case VERTHORZ:
                return line -> String.format("Vertical? %b Horizontal? %b", Double.compare(line.getEndX(), line.getStartX()) == 0, Double.compare(line.getEndY(), line.getStartY()) == 0);
        }
        return null;

    }

    String getInfo(Line line);

    public static enum InfoType {
        DISTANCE, MIDPOINT, VERTHORZ;
    }

}
