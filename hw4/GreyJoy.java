
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * The House of GreyJoy
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class GreyJoy extends NorthHouse {

    /**
     * Instantiates a new greyjoy.
     *
     * @param x, y, bounds
     */
    public GreyJoy(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        imageFilename = "kraken.png";
        image = new ImageIcon(imageFilename);
        deathAge = 100;
    }

    /**
     * Only reproduces with GreyJoys
     * @see House#canReproduceWithHouse(House)
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof GreyJoy) {
            return true;
        }
        return false;
    }

    /**
     * Only harms Starks
     * @see House#canHarmHouse(House)
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead()
            && otherHouse instanceof Stark) {
            return true;
        }
        return false;
    }

    /**
     * 1% chance to create a new GreyJoy
     * @see House#reproduceWithHouse(House)
     */
    protected House reproduceWithHouse(House otherHouse) {
        double ran = Math.random() * 100;
        if (ran < 1.0 && currentPop < MAXPOP) {
            return new GreyJoy(xPos, yPos, bounds);
        }
        return null;
    }

}