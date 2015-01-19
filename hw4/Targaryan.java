
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * The House of Targaryan
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Targaryan extends House {

    /**
     * Instantiates a new targaryan.
     *
     * @param x, y, bounds
     */
    public Targaryan(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        imageFilename = "dragon.png";
        image = new ImageIcon(imageFilename);
        immortal = true;
    }

    /**
     * Only reproduces with Targaryans
     * @see House#canReproduceWithHouse(House)
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Targaryan) {
            return true;
        }
        return false;
    }

    /**
     * Only harms Baratheons
     * @see House#canHarmHouse(House)
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && !(otherHouse instanceof Baratheon)
            && !(otherHouse instanceof Targaryan)) {
            return true;
        }
        return false;
    }

    /**
     * 1% chance to create a new Targaryan
     * @see House#reproduceWithHouse(House)
     */
    protected House reproduceWithHouse(House otherHouse) {
        double ran = Math.random() * 100;
        if (ran < 1.0 && currentPop < MAXPOP) {
            return new Targaryan(xPos, yPos, bounds);
        }
        return null;
    }

}