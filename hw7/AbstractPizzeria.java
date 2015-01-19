import java.util.Queue;
import java.util.Set;
import java.util.Collections;

/**
 * Abstract Pizzeria that is a basis for the other 3 pizzerias
 *
 * @author Matthew Keezer
 * @version 1.0
 */
public abstract class AbstractPizzeria implements Pizzeria {

    protected Queue<Customer> orderOrder;
    protected Set<Order> menu;
    protected String name;
    protected int ordersReceived, ordersAttempted,
        ordersDelivered, totalRevenue;

    /* (non-Javadoc)
     * @see asdfasd.Pizzeria#placeOrder(asdfasd.Customer)
     */
    @Override
    public void placeOrder(Customer customer) {
        orderOrder.add(customer);
        ordersReceived++;
    }

    /* (non-Javadoc)
     * @see asdfasd.Pizzeria#getCheapestMenuItem()
     */
    @Override
    public Order getCheapestMenuItem() {
        return Collections.min(menu, (a,b) -> a.sum() - b.sum());
    }

    /* (non-Javadoc)
     * @see asdfasd.Pizzeria#getMostExpensiveMenuItem()
     */
    @Override
    public Order getMostExpensiveMenuItem() {
        return Collections.max(menu, (a,b) -> a.sum() - b.sum());
    }

    /* (non-Javadoc)
     * @see asdfasd.Pizzeria#status()
     */
    @Override
    public String status() {
        return "We delivered " + (int)(((double)ordersDelivered/
        (double)ordersReceived)*100) + "% of our orders! We delivered "
        + (int)(((double)ordersDelivered/(double)ordersAttempted)*100)
        + "% of our attempted orders and made $" + totalRevenue;
    }

    /* (non-Javadoc)
     * @see asdfasd.Pizzeria#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see asdfasd.Pizzeria#processOrder()
     */
    @Override
    public void processOrder() {
        ordersAttempted++;
        Customer c = orderOrder.poll();
        if (orderOrder.peek() == null || !c.canAfford()
            || !menu.contains(c.getOrder())) {
            return;
        }
        c.removeMoney(c.getOrder().sum());
        totalRevenue += c.getOrder().sum();
        ordersDelivered++;
    }

}