package template;

import java.util.function.Consumer;

/**
 * Simple online banking used by several different banks. Each bank subclasses this class and implements the hooks
 * provided to add bank-specific behavior.
 */
public abstract class OnlineBanking {

    /**
     * Processes a customer represented by its id.
     * <p>
     * This is the usual way of implementing the template pattern.
     *
     * @param id of the customer
     */
    public void processCustomer(int id) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    /**
     * Can be implemented by different banks to make their customers happy in their own ways (provide discount,
     * send present, whatever).
     * <p>
     * This is the usual way of implementing the template pattern.
     *
     * @param customer to make happy
     */
    abstract void makeCustomerHappy(Customer customer);

    /**
     * Processes a customer represented by its id and provides a way for bank-specific customer-happiness.
     * <p>
     * This is a new, more dynamic way of implementing the template pattern.
     *
     * @param id of the customer
     * @param makeCustomerHappy bank-specific strategy to make customer happy
     */
    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }
}
