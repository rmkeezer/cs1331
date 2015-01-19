import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * This is the circle tool that draws a circle
 * @author Matthew Keezer
 * @version 1.0
 */
public class Rectangle implements Tool {

    private String name;
    private double mouseXStart;
    private double mouseYStart;

    /**
     * Rectangle constructor
     */
    public Rectangle() {
        name = "Rectangle";
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
        tg.fillRect(Math.min(e.getX(), mouseXStart),
            Math.min(e.getY(), mouseYStart),
            Math.abs(e.getX() - mouseXStart),
            Math.abs(e.getY() - mouseYStart));
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
        g.fillRect(Math.min(e.getX(), mouseXStart),
            Math.min(e.getY(), mouseYStart),
            Math.abs(e.getX() - mouseXStart),
            Math.abs(e.getY() - mouseYStart));
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