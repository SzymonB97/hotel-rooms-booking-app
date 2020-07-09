package pl.sborowy.hotelroomsbookingapp.service.impl;

import org.springframework.stereotype.Service;
import pl.sborowy.hotelroomsbookingapp.model.Room;
import pl.sborowy.hotelroomsbookingapp.repository.RoomRepository;
import pl.sborowy.hotelroomsbookingapp.service.RoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    // --fields--
    private final RoomRepository roomRepository = new RoomRepository();

    // --public methods--
    @Override
    public void addRoom(Room newRoom) {
        roomRepository.addRoom(newRoom);
    }

    @Override
    public void updateRoom(Room updateRoom) {
        roomRepository.updateRoom(updateRoom);
    }

    @Override
    public void removeRoom(int id) {
        roomRepository.removeRoom(id);
    }

    @Override
    public List<Room> getRoomsList() {
        return roomRepository.getRooms();
    }

    @Override
    public Room getRoom(int id) {
        return roomRepository.getRoom(id);
    }
}
