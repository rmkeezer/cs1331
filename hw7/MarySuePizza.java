import java.util.Set;
import java.util.PriorityQueue;

/**
 * Mary Sue Pizza
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class MarySuePizza extends AbstractPizzeria {

    /**
     * Instantiates a new mary sue pizza.
     *
     * @param s
     */
    public MarySuePizza(Set<Order> s) {
        orderOrder = new PriorityQueue<Customer>(
            (a,b) -> b.getOrder().sum() -
            a.getOrder().sum());
        menu = s;
        name = "Mary Sue Pizza";
    }

}
