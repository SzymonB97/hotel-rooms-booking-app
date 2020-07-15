package pl.sborowy.hotelroomsbookingapp.repository;

import pl.sborowy.hotelroomsbookingapp.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepository {

    // --constants--
    private static final String CUSTOMER_DOESNT_EXIST = "That customer doesn't exist";

    // --fields--
    private static int idValue = 1;
    private List<Customer> customers = new ArrayList<>();

    // --constructors--
    public CustomerRepository() {
        addCustomer(new Customer("John", "Doe"));
        addCustomer(new Customer("Jake", "Williams"));
        addCustomer(new Customer("Terry", "Smith"));
    }

    // --public methods--
    public void addCustomer(Customer newCustomer) {
        newCustomer.setId(idValue);
        customers.add(newCustomer);
        idValue++;
    }

    public void updateCustomer(Customer updateCustomer) {
        Customer customer = findCustomer(updateCustomer);

        if (customer != null) {
            customers.set(customer.getId(), updateCustomer);
        } else {
            throw new NullPointerException(CUSTOMER_DOESNT_EXIST);
        }
    }

    public void removeCustomer(int id) {
        Customer customer = findCustomer(id);

        if (customer != null) {
            customers.remove(customer);
        } else {
            throw new NullPointerException(CUSTOMER_DOESNT_EXIST);
        }
    }

    public Customer getCustomer(int id) {
        Customer customer = findCustomer(id);

        if (customer != null) {
            return customer;
        } else {
            throw new NullPointerException(CUSTOMER_DOESNT_EXIST);
        }
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    // --private methods--
    private Customer findCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    private Customer findCustomer(Customer customerToFind) {
        for (Customer customer : customers) {
            if (customer.getId() == customerToFind.getId()) {
                return customer;
            }
        }

        return null;
    }
}
