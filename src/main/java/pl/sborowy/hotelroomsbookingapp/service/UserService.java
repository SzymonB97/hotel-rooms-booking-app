package pl.sborowy.hotelroomsbookingapp.service;

import lombok.NonNull;
import pl.sborowy.hotelroomsbookingapp.entity.User;

import java.util.List;

public interface UserService {

    void save(@NonNull User newCustomer);

    User findById(int id);

    void deleteById(int id);

    List<User> findAll();
}
