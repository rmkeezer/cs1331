
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * The House of Targaryan
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Tully extends NorthHouse {

    /**
     * Instantiates a new tully.
     *
     * @param x, y, bounds
     */
    public Tully(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        imageFilename = "trout.png";
        image = new ImageIcon(imageFilename);
        deathAge = 150;
    }

    /**
     * Only reproduces with Starks
     * @see House#canReproduceWithHouse(House)
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Stark) {
            return true;
        }
        return false;
    }

    /**
     * Only harms Lannisters
     * @see House#canHarmHouse(House)
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Tully) {
            double ran = Math.random();
            if (ran <= 0.2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1% chance to create a new Tully
     * @see House#reproduceWithHouse(House)
     */
    protected House reproduceWithHouse(House otherHouse) {
        double ran = Math.random() * 100;
        if (ran < 1.0 && currentPop < MAXPOP) {
            return new Tully(xPos, yPos, bounds);
        }
        return null;
    }

}