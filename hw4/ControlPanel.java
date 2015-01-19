
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the ControlPanel for Game of Thrones. It allows the
 * user to pick which House it would like to add next.
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class ControlPanel extends JPanel {

    private JButton stark, baratheon, lannister, tully, targaryan, greyjoy;
    private JLabel current;
    private String houseType;

    /**
     * Instantiates a new control panel.
     */
    public ControlPanel() {
        setPreferredSize(new Dimension(150, Westeros.HEIGHT));

        stark = new JButton("Stark");
        stark.addActionListener(new ButtonListener("Stark"));
        add(stark);

        baratheon = new JButton("Baratheon");
        baratheon.addActionListener(new ButtonListener("Baratheon"));
        add(baratheon);

        lannister = new JButton("Lannister");
        lannister.addActionListener(new ButtonListener("Lannister"));
        add(lannister);

        targaryan = new JButton("Targaryan");
        targaryan.addActionListener(new ButtonListener("Targaryan"));
        add(targaryan);

        tully = new JButton("Tully");
        tully.addActionListener(new ButtonListener("Tully"));
        add(tully);

        greyjoy = new JButton("Greyjoy");
        greyjoy.addActionListener(new ButtonListener("Greyjoy"));
        add(greyjoy);

        //default starting animal
        houseType = "Stark";
        add(new JLabel("Current Animal"));
        current = new JLabel("Stark");
        add(current);

        //implement timer speed control if you feel adventurous
    }

    /**
     * Gets the house type.
     *
     * @return the house type
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * The listener interface for receiving button events.
     *
     * @see ButtonEvent
     */
    public class ButtonListener implements ActionListener {

        private String name;

        /**
         * Instantiates a new button listener.
         *
         * @param className
         */
        public ButtonListener(String className) {
            name = className;
        }

        /**
         * Changes name of current House if an action occurs
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e) {
            houseType = name;
            current.setText(name);
        }
    }
}
