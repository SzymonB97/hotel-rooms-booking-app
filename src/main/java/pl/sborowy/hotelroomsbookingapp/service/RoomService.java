package pl.sborowy.hotelroomsbookingapp.service;

import lombok.NonNull;
import pl.sborowy.hotelroomsbookingapp.entity.Room;

import java.util.List;

public interface RoomService {

    void save(@NonNull Room newRoom);

    Room findById(int id);

    void deleteById(int id);

    List<Room> findAll();
}
