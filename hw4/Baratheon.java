
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * The House of Baratheon
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Baratheon extends SouthHouse {

    /**
     * Instantiates a new baratheon.
     *
     * @param x, y, bounds
     */
    public Baratheon(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        imageFilename = "stag.png";
        image = new ImageIcon(imageFilename);
    }

    /**
     * Only reproduces with Lannisters
     * @see House#canReproduceWithHouse(House)
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Lannister) {
            return true;
        }
        return false;
    }

    /**
     * Only harms Targaryans
     * @see House#canHarmHouse(House)
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Targaryan) {
            return true;
        }
        return false;
    }

    /**
     * 1% chance to create a new Baratheon
     * @see House#reproduceWithHouse(House)
     */
    protected House reproduceWithHouse(House otherHouse) {
        double ran = Math.random() * 100;
        if (ran < 1.0 && currentPop < MAXPOP) {
            return new Baratheon(xPos, yPos, bounds);
        }
        return null;
    }

}