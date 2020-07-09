package pl.sborowy.hotelroomsbookingapp.service;

import lombok.NonNull;
import pl.sborowy.hotelroomsbookingapp.model.Room;

import java.util.List;

public interface RoomService {

    void addRoom(@NonNull Room newRoom);

    void updateRoom(@NonNull Room updateRoom);

    void removeRoom(int id);

    List<Room> getRoomsList();

    Room getRoom(int id);
}
