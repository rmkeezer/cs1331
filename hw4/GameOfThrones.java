
import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * The driver class
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class GameOfThrones {

    /**
     * The main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Westeros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ControlPanel control = new ControlPanel();
        frame.add(control, BorderLayout.WEST);
        frame.add(new Westeros(control)); //defaults to CENTER
        frame.pack();
        frame.setVisible(true);
    }
}