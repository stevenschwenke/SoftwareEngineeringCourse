package template;

import org.junit.jupiter.api.Test;

class OnlineBankingTest {

    @Test
    void happyCustomerWithoutLambda() {

        // prints a happy customer to the console because of implementation below
        new SpecificOnlineBanking().processCustomer(42);
    }

    @Test
    void happyCustomerWithLambda() {

        // prints a happy customer to the console because of given lambda
        new SpecificOnlineBanking().processCustomer(42, c -> System.out.println("I am a happy customer: " + c.toString()));
    }

    class SpecificOnlineBanking extends OnlineBanking {

        @Override
        void makeCustomerHappy(Customer customer) {
            System.out.println("I am a happy customer: " + customer.toString());
        }
    }
}
