import java.util.Set;
import java.util.ArrayDeque;

/**
 * Cascade Pizza
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public class CascadePizza extends AbstractPizzeria {

    /**
     * Instantiates a new cascade pizza.
     *
     * @param s
     */
    public CascadePizza(Set<Order> s) {
        orderOrder = new ArrayDeque<Customer>();
        menu = s;
        name = "Cascade Pizza";
    }


}