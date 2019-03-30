import javafx.scene.shape.Line;

public class LineUtils {

    static double getAngle(Line line) {

        double dx = line.getEndX() - line.getStartX();
        double dy = line.getEndY() - line.getStartY();

        double inRads = Math.atan2(dy, dx);

        // We need to map to coord system when 0 degree is at 3 O'clock, 270 at 12 O'clock
        if (inRads < 0) {
            inRads = Math.abs(inRads);
        } else {
            inRads = 2 * Math.PI - inRads;
        }

        return Math.toDegrees(inRads);
    }

}
