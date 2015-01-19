import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

/**
 * This is the Pencil tool that draws wherever your mouse drags
 * @author Matthew Keezer
 * @version 1.0
 */
public class Pencil implements Tool {

    private String name;
    private double mouseXStart;
    private double mouseYStart;

    /**
     * Pencil constructor
     */
    public Pencil() {
        name = "Pencil";
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
        g.strokeLine(mouseXStart, mouseYStart, e.getX(), e.getY());
        mouseXStart = e.getX();
        mouseYStart = e.getY();
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