import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;

/**
 * Ths is the driver for the planetarium program
 * @author Matthew Keezer
 * @version 1.0
 */
public class Planetarium extends Application {

    public static final double HSIZE = 800;
    public static final double VSIZE = 800;

    private double sunRadius = 65.0;

    /**
     * The start of the program that sets
     * the stage and adds the components
     * @param stage the Stage
     */
    public void start(Stage stage) {
        stage.setTitle("Drawing");

        HBox outBox = new HBox();
        Pane drawPane = new Pane();

        outBox.setBackground(new Background(new BackgroundFill(
            Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));


        Canvas canvas = new Canvas(HSIZE, VSIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.YELLOW);

        gc.fillOval((canvas.getWidth() / 2.0) - sunRadius,
            (canvas.getHeight() / 2.0) - sunRadius,
            sunRadius * 2,
            sunRadius * 2);

        outBox.getChildren().addAll(drawPane);

        drawPane.getChildren().addAll(canvas, Planet.EARTH.getPath(),
            Planet.EARTH.getCircle(), Planet.MERCURY.getPath(),
            Planet.MERCURY.getCircle(), Planet.VENUS.getPath(),
            Planet.VENUS.getCircle(), Planet.MARS.getPath(),
            Planet.MARS.getCircle());

        stage.setScene(new Scene(outBox));
        stage.setMinWidth(HSIZE);
        stage.setMinHeight(VSIZE);
        stage.setMaxWidth(HSIZE);
        stage.setMaxHeight(VSIZE);
        stage.setResizable(false);
        stage.show();

    }

}