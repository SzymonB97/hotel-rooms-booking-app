package pl.sborowy.hotelroomsbookingapp.service;

import lombok.NonNull;
import pl.sborowy.hotelroomsbookingapp.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(@NonNull Customer newCustomer);

    void updateCustomer(@NonNull Customer updateCustomer);

    void removeCustomer(int id);

    List<Customer> getCustomersList();

    Customer getCustomer(int id);
}
