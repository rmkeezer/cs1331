import java.util.HashSet;

/**
 * Order that holds ingrediants
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Order extends HashSet<Ingredient> {

    /**
     * Instantiates a new order.
     */
    public Order() {
        super();
    }

    /* (non-Javadoc)
     * @see java.util.HashSet#add(java.lang.Object)
     */
    public boolean add(Ingredient i) {
        return super.add(i);
    }

    /**
     * Sum.
     *
     * @return the sum
     */
    public int sum() {
        int sum = 0;
        for (Ingredient i : this) {
            sum += i.getPrice();
        }
        return sum;
    }

    /**
     * If Ingrediants lists are equal
     *
     * @return true if this and o are equals
     */
    public boolean equals(Object o) {
        if (size() != ((Order) o).size()) {
            return false;
        }
        for (Ingredient i : this) {
            boolean doesContain = false;
            for (Ingredient j : (Order) o) {
                if (i == j) {
                    doesContain = true;
                }
            }
            if (!doesContain) {
                return false;
            }
        }
        return true;
    }

}