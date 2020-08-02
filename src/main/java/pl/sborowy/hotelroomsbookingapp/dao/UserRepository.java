package pl.sborowy.hotelroomsbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sborowy.hotelroomsbookingapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
