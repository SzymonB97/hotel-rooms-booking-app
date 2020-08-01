package pl.sborowy.hotelroomsbookingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sborowy.hotelroomsbookingapp.entity.Customer;
import pl.sborowy.hotelroomsbookingapp.dao.CustomerRepository;
import pl.sborowy.hotelroomsbookingapp.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    // --fields--
    private final CustomerRepository customerRepository;

    // --constructors--
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // --public methods--
    @Override
    public void save(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new NullPointerException("Customer with id " + id + " doesn't exists!");
        }
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findFirstByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findFirstByFirstNameAndLastName(firstName, lastName);
    }
}
