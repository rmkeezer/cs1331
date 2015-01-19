import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * This is the class for the line tool that draws a line
 * @author Matthew Keezer
 * @version 1.0
 */
public class Line implements Tool {

    private String name;
    private double mouseXStart;
    private double mouseYStart;

    /**
     * Line constructor
     */
    public Line() {
        name = "Line";
    }

    /**
     * Tool method that is called when the mouse is pressed.
     * Usually involves beginning drawing something.
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     * @param tg overlay graphics
     */
    public void onPress(MouseEvent e, GraphicsContext g,
        GraphicsContext tg) {
        mouseXStart = e.getX();
        mouseYStart = e.getY();
    }

    /**
     * Tool method that is called when the mouse is dragged.
     * Usually involves updating the drawing location.
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     * @param tg overlay graphics
     */
    public void onDrag(MouseEvent e, GraphicsContext g,
        GraphicsContext tg) {
        tg.clearRect(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        tg.strokeLine(mouseXStart, mouseYStart, e.getX(), e.getY());
    }

    /**
     * Tool method that is called when the mouse is released.
     * Usually involves completing an individual stroke/shape.
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     * @param tg overlay graphics
     */
    public void onRelease(MouseEvent e, GraphicsContext g,
        GraphicsContext tg) {
        tg.clearRect(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
        g.strokeLine(mouseXStart, mouseYStart, e.getX(), e.getY());
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return name;
    }

}