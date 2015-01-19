/**
 * Customer Class
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class Customer implements Comparable<Customer> {

    private int money;
    private Order order;

    /**
     * Instantiates a new customer.
     *
     * @param o
     */
    public Customer(Order o) {
        money = (int) (Math.random() * 30) + 5;
        order = o;
    }

    /**
     * Can afford.
     *
     * @return true, if successful
     */
    public boolean canAfford() {
        return money > order.sum();
    }

    /**
     * Gets the money.
     *
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Removes the money.
     *
     * @param m
     */
    public void removeMoney(int m) {
        money -= m;
    }

    /**
     * Gets the order.
     *
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Gets the cost.
     *
     * @return the cost
     */
    public int getCost() {
        return order.sum();
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Customer c) {
        return c.getMoney() - money;
    }

}