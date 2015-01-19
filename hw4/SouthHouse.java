
import java.awt.Rectangle;

/**
 * The Northern House Class
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public abstract class SouthHouse extends House {

    protected boolean specialActive;

    /**
     * Instantiates a new south house.
     *
     * @param x, y, bounds
     */
    public SouthHouse(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        specialActive = false;
    }

    /**
     * Increases the Southern House's speed when in the south
     */
    protected void checkSpecial() {
        if (!specialActive && yPos > bounds.height / 2) {
            speed += 5;
            specialActive = true;
        }
        if (specialActive && yPos < bounds.height / 2) {
            speed -= 5;
            specialActive = false;
        }
    }

}