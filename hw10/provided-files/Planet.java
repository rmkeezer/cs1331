import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.ArcTo;
import javafx.util.Duration;
import javafx.animation.Transition;
import javafx.animation.Interpolator;

/**
 * This enum represents a Planet object
 * @author Matthew Keezer
 * @version 1.0
 */
public enum Planet {

    EARTH(Color.SPRINGGREEN, 1, 1, 1),
    MERCURY(Color.SILVER, 0.1915, 0.387, 0.24),
    VENUS(Color.GREEN, 0.4745, 0.723, 0.62),
    MARS(Color.RED, 0.266, 1.52, 1.88);

    /** DO NOT MODIFY IT'S FOR YOUR OWN GOOD**/
    private final int earthRadius = 35;
    private final int earthDistance = 265;
    private final int earthPeriod = 5;
    /** OK YOU'RE GOOD GO AHEAD AND DO WORK NOW **/

    private final double radius;
    private final double distance;
    private final double period;

    private final Path path;
    private final PathTransition pathTrans;
    private final Circle circle;

    /**
     * Creates a Planet
     * @param c the Color of the Planet
     * @param r the radius
     * @param d the distance
     * @param p the period
     */
    Planet(Color c, double r, double d, double p) {
        radius = r * earthRadius;
        distance = d * earthDistance;
        period = p * earthPeriod;

        double hSize = Planetarium.HSIZE;
        double vSize = Planetarium.VSIZE;

        circle = new Circle(0, 0, radius);
        circle.setFill(c);

        path = new Path();
        path.getElements().add(new MoveTo((hSize / 2.0) + distance,
            (vSize / 2.0)));
        ArcTo arcTo = new ArcTo();
        arcTo.setX((hSize / 2.0) - distance);
        arcTo.setY((vSize / 2.0));
        arcTo.setRadiusX(distance);
        arcTo.setRadiusY(distance);
        path.getElements().add(arcTo);
        ArcTo arcTo2 = new ArcTo();
        arcTo2.setX((hSize / 2.0) + distance);
        arcTo2.setY((vSize / 2.0));
        arcTo2.setRadiusX(distance);
        arcTo2.setRadiusY(distance);
        path.getElements().add(arcTo2);

        pathTrans = new PathTransition();
        pathTrans.setDuration(Duration.seconds(period));
        pathTrans.setNode(circle);
        pathTrans.setPath(path);
        pathTrans.setCycleCount(Transition.INDEFINITE);
        pathTrans.setInterpolator(Interpolator.LINEAR);

        pathTrans.play();

        path.setStroke(Color.WHITE);

    }

    /**
     * Gets the circle
     * @return the circle
     */
    public Circle getCircle() {
        return circle;
    }

    /**
     * Gets the Path
     * @return the path
     */
    public Path getPath() {
        return path;
    }

}

