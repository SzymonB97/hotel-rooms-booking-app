package pl.sborowy.hotelroomsbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sborowy.hotelroomsbookingapp.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
