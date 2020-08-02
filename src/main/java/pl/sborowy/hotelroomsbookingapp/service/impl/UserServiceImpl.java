package pl.sborowy.hotelroomsbookingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sborowy.hotelroomsbookingapp.entity.User;
import pl.sborowy.hotelroomsbookingapp.dao.UserRepository;
import pl.sborowy.hotelroomsbookingapp.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    // --fields--
    private final UserRepository customerRepository;

    // --constructors--
    @Autowired
    public UserServiceImpl(UserRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // --public methods--
    @Override
    public void save(User newCustomer) {
        customerRepository.save(newCustomer);
    }

    @Override
    public User findById(int id) {
        Optional<User> optionalCustomer = customerRepository.findById(id);

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
    public List<User> findAll() {
        return customerRepository.findAll();
    }
}
