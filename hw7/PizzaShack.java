import java.util.Set;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Pizza Shack
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class PizzaShack extends AbstractPizzeria {

    /**
     * Instantiates a new pizza shack.
     *
     * @param s the s
     */
    public PizzaShack(Set<Order> s) {
        Comparator<Customer> c = (a,b) -> (b.getMoney()-b.getCost())
        - (a.getMoney()-a.getCost());
        orderOrder = new PriorityQueue<Customer>(
            c.thenComparing((a,b) -> b.getOrder().sum()
        - a.getOrder().sum()));
        menu = s;
        name = "Pizza Shack";
    }

}