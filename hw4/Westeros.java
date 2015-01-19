
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * This class represents Westeros.
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Westeros extends JPanel {

    public static final int WIDTH = 600, HEIGHT = 600;
    private ArrayList<House> houses = new ArrayList<House>();
    private ControlPanel cPanel;
    private Timer timer;
    private Rectangle bounds;

    /**
     * Instantiates a new westeros.
     *
     * @param control
     */
    public Westeros(ControlPanel control) {
        cPanel = control;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.GREEN);
        bounds = new Rectangle(0, 0, WIDTH, HEIGHT);

        addMouseListener(new ClickListener());

        timer = new Timer(100, new TimerListener());
        timer.start();
    }

    /**
     * Move all.
     */
    public void moveAll() {
        for (House a : houses) {
            a.move();
        }
    }

    /**
     * Check food chain.
     */
    public void checkFoodChain() {
        for (House a : houses) {
            for (House other : houses) {
                if (a.collidesWithHouse(other)) {
                    if (a != other
                        && a.canHarmHouse(other)) {
                        a.harmHouse(other);
                    }
                }
            }
        }
    }

    /**
     * Check reproduce.
     */
    public void checkReproduce() {
        int currHousesSize = houses.size();
        for (int i = 0; i < currHousesSize; i++) {
            //don't want double reproduction
            for (int j = 0; j < currHousesSize; j++) {
                if (i != j) {
                    if (houses.get(i).
                        collidesWithHouse(houses.get(j))) {

                        if (houses.get(i).
                            canReproduceWithHouse(houses.get(j))) {

                            House baby = houses.get(i).
                                reproduceWithHouse(houses.get(j));

                            if (baby != null) {
                                //Prevent Heapsize crashes
                                if (houses.size() < 1000) {
                                    houses.add(baby);
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Check dead.
     */
    public void checkDead() {
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i).isDead()) {
                houses.remove(i);
                i--;
            }
        }
    }

    /**
     * Euthanize.
     */
    public void euthanize() {
        for (House a : houses) {
            if (a.isOld()) {
                a.die();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, WIDTH, HEIGHT / 2);
        for (House a : houses) {
            a.draw(g);
        }
    }

    /**
     * The listener interface for receiving timer events.
     */
    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            moveAll();
            checkReproduce();
            checkFoodChain();
            euthanize();
            checkDead();
            repaint();
        }
    }

    /**
     * The listener interface for receiving click events.
     */
    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            //Determine type of House to create using ControlPanel
            //Based on the button that was last clicked
            String houseType = cPanel.getHouseType();
            Point p = e.getPoint();

            //Create the corresponding House
            if (houseType.equals("Stark")) {
                houses.add(new Stark(p.x, p.y, bounds));
            } else if (houseType.equals("Baratheon")) {
                houses.add(new Baratheon(p.x, p.y, bounds));
            } else if (houseType.equals("Lannister")) {
                houses.add(new Lannister(p.x, p.y, bounds));
            } else if (houseType.equals("Targaryan")) {
                houses.add(new Targaryan(p.x, p.y, bounds));
            } else if (houseType.equals("Tully")) {
                houses.add(new Tully(p.x, p.y, bounds));
            } else if (houseType.equals("Greyjoy")) {
                houses.add(new GreyJoy(p.x, p.y, bounds));
            }

            repaint();
        }
    }
}
