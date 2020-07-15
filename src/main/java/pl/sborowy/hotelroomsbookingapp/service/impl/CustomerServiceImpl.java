package pl.sborowy.hotelroomsbookingapp.service.impl;

import org.springframework.stereotype.Service;
import pl.sborowy.hotelroomsbookingapp.model.Customer;
import pl.sborowy.hotelroomsbookingapp.repository.CustomerRepository;
import pl.sborowy.hotelroomsbookingapp.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // --fields--
    private final CustomerRepository customerRepository = new CustomerRepository();

    // --public methods--
    @Override
    public void addCustomer(Customer newCustomer) {
        customerRepository.addCustomer(newCustomer);
    }

    @Override
    public void updateCustomer(Customer updateCustomer) {
        customerRepository.updateCustomer(updateCustomer);
    }

    @Override
    public void removeCustomer(int id) {
        customerRepository.removeCustomer(id);
    }

    @Override
    public List<Customer> getCustomersList() {
        return customerRepository.getCustomers();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }
}
