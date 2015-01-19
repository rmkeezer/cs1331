
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * The House of Lannister
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Lannister extends SouthHouse {

    /**
     * Instantiates a new lannister.
     *
     * @param x, y, bounds
     */
    public Lannister(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        imageFilename = "lion.png";
        image = new ImageIcon(imageFilename);
        deathAge = 75;
    }

    /**
     * Only reproduces with Lannisters or Baratheons
     * @see House#canReproduceWithHouse(House)
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && (otherHouse instanceof Lannister
            || otherHouse instanceof Baratheon)) {
            return true;
        }
        return false;
    }

    /**
     * Only harms Starks and Tullys
     * @see House#canHarmHouse(House)
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()) {
            double ran = Math.random();
            if (otherHouse instanceof Stark
                && ran <= 0.6) {
                return true;
            }
            if (otherHouse instanceof Tully
                && ran <= 0.8) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1% chance to create a new Lannister
     * @see House#reproduceWithHouse(House)
     */
    protected House reproduceWithHouse(House otherHouse) {
        double ran = Math.random() * 100;
        if (ran < 1.0 && currentPop < MAXPOP) {
            return new Lannister(xPos, yPos, bounds);
        }
        return null;
    }


}