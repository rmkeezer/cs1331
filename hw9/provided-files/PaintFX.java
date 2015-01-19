import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

/**
 * This is the Driver class that creates the GUI
 * @author Matthew Keezer
 * @version 1.0
 */
public class PaintFX extends Application {

    private Tool currentTool;
    private double hSize = 400;
    private double vSize = 400;

    /**
     * Start to the application
     * @param stage the stage
     */
    public void start(Stage stage) {
        stage.setTitle("Drawing");

        HBox outBox = new HBox();
        VBox toolList = new VBox();
        Pane drawPane = new Pane();

        toolList.setBackground(new Background(new BackgroundFill(
            Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Canvas canvas = new Canvas(hSize, vSize);
        Canvas tempCanvas = new Canvas(hSize, vSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext gct = tempCanvas.getGraphicsContext2D();


        Label strokeColor = new Label("Stroke Color");
        final ColorPicker sColorPicker = new ColorPicker();
        sColorPicker.setValue(Color.BLACK);
        sColorPicker.setOnAction((t) -> {
                gc.setStroke(sColorPicker.getValue());
                gct.setStroke(sColorPicker.getValue());
            });
        sColorPicker.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
        Label fillColor = new Label("Fill Color");
        final ColorPicker fColorPicker = new ColorPicker();
        fColorPicker.setValue(Color.BLACK);
        fColorPicker.setOnAction((t) -> {
                gc.setFill(fColorPicker.getValue());
                gct.setFill(fColorPicker.getValue());
            });

        Label toolLabel = new Label("Tools");
        Button pencilBTN = new Button("Pencil");
        pencilBTN.addEventHandler(MouseEvent.MOUSE_CLICKED,
            (e) -> {
                currentTool = new Pencil()
            });
        Button lineBTN = new Button("Line");
        lineBTN.addEventHandler(MouseEvent.MOUSE_CLICKED,
            (e) -> {
                currentTool = new Line()
            });
        Button circleBTN = new Button("Circle");
        circleBTN.addEventHandler(MouseEvent.MOUSE_CLICKED,
            (e) -> {
                currentTool = new Circle()
            });
        Button rectangleBTN = new Button("Rectangle");
        rectangleBTN.addEventHandler(MouseEvent.MOUSE_CLICKED,
            (e) -> {
                currentTool = new Rectangle()
            });
        Button clearBTN = new Button("Clear");
        clearBTN.addEventHandler(MouseEvent.MOUSE_CLICKED,
            (e) -> {
                gc.clearRect(0, 0, hSize, vSize)
            });


        toolList.getChildren().addAll(strokeColor, sColorPicker,
            fillColor, fColorPicker, toolLabel, pencilBTN, lineBTN,
            circleBTN, rectangleBTN, clearBTN);

        outBox.getChildren().addAll(toolList, drawPane);


        currentTool = new Pencil();

        tempCanvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
            (e) -> {
                currentTool.onPress(e, gc, gct)
            });

        tempCanvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
            (e) -> {
                currentTool.onDrag(e, gc, gct)
            });

        tempCanvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
            (e) -> {
                currentTool.onRelease(e, gc, gct)
            });

        drawPane.getChildren().addAll(canvas, tempCanvas);

        tempCanvas.widthProperty().addListener(evt -> {
                hSize = tempCanvas.getWidth();
                vSize = tempCanvas.getHeight();
            });

        canvas.widthProperty().addListener(evt -> {
                hSize = canvas.getWidth();
                vSize = canvas.getHeight();
            });

        outBox.setMinWidth(400);
        outBox.setMinHeight(400);

        tempCanvas.widthProperty().bind(outBox.widthProperty());
        tempCanvas.heightProperty().bind(outBox.heightProperty());
        canvas.widthProperty().bind(outBox.widthProperty());
        canvas.heightProperty().bind(outBox.heightProperty());

        stage.setScene(new Scene(outBox));
        stage.show();

    }
}