package pl.sborowy.hotelroomsbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sborowy.hotelroomsbookingapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findFirstByFirstNameAndLastName(String firstName, String lastName);
}
