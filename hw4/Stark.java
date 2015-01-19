
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * The House of Stark
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Stark extends NorthHouse {

    /**
     * Instantiates a new stark.
     *
     * @param x, y, bounds
     */
    public Stark(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        imageFilename = "direwolf.png";
        image = new ImageIcon(imageFilename);
        deathAge = 125;
    }

    /**
     * Only reproduces with Tullys
     * @see House#canReproduceWithHouse(House)
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Tully) {
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
            && otherHouse instanceof Lannister) {
            double ran = Math.random();
            if (ran <= 0.4) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1% chance to create a new Stark
     * @see House#reproduceWithHouse(House)
     */
    protected House reproduceWithHouse(House otherHouse) {
        double ran = Math.random() * 100;
        if (ran < 1.0) {
            return new Stark(xPos, yPos, bounds);
        }
        return null;
    }

}