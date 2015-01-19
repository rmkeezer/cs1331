
import java.awt.Rectangle;

/**
 * The Northern House Class
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public abstract class NorthHouse extends House {

    protected boolean specialActive;

    /**
     * Instantiates a new north house.
     *
     * @param x, y, bounds
     */
    public NorthHouse(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        specialActive = false;
    }

    /**
     * Increases the Northern House's health when in the north
     */
    protected void checkSpecial() {
        if (!specialActive && yPos < bounds.height / 2) {
            health += 20;
            specialActive = true;
        }
        if (specialActive && yPos > bounds.height / 2) {
            health -= 20;
            specialActive = false;
        }
    }

}