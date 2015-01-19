
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

/**
 * The abstract House for the Game of Thrones Simulation.
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public abstract class House {

    protected ImageIcon image;
    protected String imageFilename;
    protected int xPos, yPos, health, age, speed, deathAge;
    protected Rectangle bounds;
    protected boolean dead, immortal, changeDirection;
    protected double direction;
    protected static final int MAXPOP = 999;
    protected static int currentPop = 0;

    /**
     * Instantiates a new house.
     *
     * @param x, y, b
     */
    public House(int x, int y, Rectangle b) {
        xPos = x;
        yPos = y;
        bounds = b;
        health = 100;
        age = 0;
        direction = 0;
        speed = 10;
        deathAge = 100;
        immortal = false;
        changeDirection = true;
        currentPop++;
    }

    /**
     * Draw.
     *
     * @param g
     */
    protected void draw(Graphics g) {
        if (!dead) {
            image.paintIcon(null, g, xPos, yPos);
            g.setColor(Color.BLACK);
            g.drawString("" + health, xPos, yPos - 10);
            g.drawRect(xPos, yPos, image.getImage().getWidth(null),
                image.getImage().getHeight(null));
        }
    }

    /**
     * Can harm house.
     *
     * @param otherHouse
     * @return true, if can harm house
     */
    abstract boolean canHarmHouse(House otherHouse);

    /**
     * Can reproduce with house.
     *
     * @param otherHouse
     * @return true, if can reproduce with house
     */
    abstract boolean canReproduceWithHouse(House otherHouse);

    /**
     * 1% chance to create a new house.
     *
     * @param otherHouse
     * @return copy of this House
     */
    abstract House reproduceWithHouse(House otherHouse);

    /**
     * Move.
     */
    protected void move() {
        if (!dead) {
            boolean notMoved = true;
            while (notMoved) {
                if (changeDirection) {
                    direction = Math.random() * 4;
                    changeDirection = false;
                }
                double ranMov = Math.random() * speed + 5;
                if (direction <= 1.0 && xPos + image.getImage().getWidth(null)
                    + ranMov < bounds.width - 10) {
                    xPos += ranMov;
                    notMoved = false;
                } else if (direction <= 2.0 && direction > 1.0
                    && xPos - ranMov > 10) {
                    xPos -= ranMov;
                    notMoved = false;
                } else if (direction <= 3.0 && direction > 2.0
                    && yPos + image.getImage().getHeight(null) + ranMov
                    < bounds.height - 10) {
                    yPos += ranMov;
                    notMoved = false;
                } else if (direction <= 4.0 && direction > 3.0
                    && yPos - ranMov > 10) {
                    yPos -= ranMov;
                    notMoved = false;
                } else {
                    changeDirection = true;
                }
            }
            health -= 1;
            if (health < 0) {
                die();
            }
            age += 1;
            checkSpecial();
        }
    }

    /**
     * Check special.
     */
    protected void checkSpecial() { }

    /**
     * Collides with house.
     *
     * @param otherHouse
     * @return true, if successful
     */
    protected boolean collidesWithHouse(House otherHouse) {
        if (!dead && !otherHouse.isDead() && otherHouse != this) {
            Image tempImg = image.getImage();
            Image tempImg2 = otherHouse.getImage().getImage();
            Rectangle tempRect = new Rectangle(xPos, yPos,
                tempImg.getWidth(null), tempImg.getHeight(null));
            Rectangle tempRect2 = new Rectangle(otherHouse.getX(),
                otherHouse.getY(), tempImg2.getWidth(null),
                tempImg2.getHeight(null));
            return tempRect.intersects(tempRect2);
        }
        return false;
    }

    /**
     * Checks if too old.
     *
     * @return true, if too old
     */
    protected boolean isOld() {
        return age > deathAge && !immortal;
    }

    /**
     * Harm house.
     *
     * @param otherHouse
     */
    protected void harmHouse(House otherHouse) {
        otherHouse.setHealth(otherHouse.getHealth() - 10);
    }

    /**
     * Die.
     */
    protected void die() {
        xPos = -50;
        yPos = -50;
        dead = true;
        currentPop--;
    }

    /**
     * Checks if dead.
     *
     * @return true, if dead
     */
    protected boolean isDead() {
        return dead;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public int getX() {
        return xPos;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public int getY() {
        return yPos;
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Gets the image filename.
     *
     * @return the image filename
     */
    public String getImageFilename() {
        return imageFilename;
    }

    /**
     * Gets the health.
     *
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health.
     *
     * @param h
     */
    public void setHealth(int h) {
        health = h;
    }
}
