package pl.sborowy.hotelroomsbookingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sborowy.hotelroomsbookingapp.dao.RoomRepository;
import pl.sborowy.hotelroomsbookingapp.entity.Room;
import pl.sborowy.hotelroomsbookingapp.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    // --fields--
    private final RoomRepository roomRepository;

    // --constructors--
    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // --public methods--
    @Override
    public void save(Room newRoom) {
        roomRepository.save(newRoom);
    }

    @Override
    public Room findById(int id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);

        if (optionalRoom.isPresent()) {
            return optionalRoom.get();
        } else {
            throw new NullPointerException("Room with id " + id + " doesn't exists!");
        }
    }

    @Override
    public void deleteById(int id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
