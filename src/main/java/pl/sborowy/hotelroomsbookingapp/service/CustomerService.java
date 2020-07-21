package pl.sborowy.hotelroomsbookingapp.service;

import lombok.NonNull;
import pl.sborowy.hotelroomsbookingapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    void save(@NonNull Customer newCustomer);

    Customer findById(int id);

    void deleteById(int id);

    List<Customer> findAll();
}
