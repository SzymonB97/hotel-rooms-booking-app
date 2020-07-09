package pl.sborowy.hotelroomsbookingapp.repository;

import pl.sborowy.hotelroomsbookingapp.model.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomRepository {

    // --constants--
    private static final String ROOM_DOESNT_EXIST = "That room doesn't exist";

    // --fields--
    private static int idValue = 1;
    private List<Room> rooms = new ArrayList<>();

    // --constructors--
    public RoomRepository() {
        addRoom(new Room("1","2", 12.50));
        addRoom(new Room("2","2", 12.50));
        addRoom(new Room("3","4", 25.00));
    }

    // --public methods--
    public void addRoom(Room newRoom) {
        newRoom.setId(idValue);
        rooms.add(newRoom);
        idValue++;
    }

    public void updateRoom(Room updateRoom) {
        Room room = findRoom(updateRoom);

        if (room != null) {
            rooms.set(room.getId(), updateRoom);
        } else {
            throw new NullPointerException(ROOM_DOESNT_EXIST);
        }
    }

    public void removeRoom(int id) {
        Room room = findRoom(id);

        if (room != null) {
            rooms.remove(room);
        } else {
            throw new NullPointerException(ROOM_DOESNT_EXIST);
        }
    }

    public Room getRoom(int id) {
        Room room = findRoom(id);

        if (room != null) {
            return room;
        } else {
            throw new NullPointerException(ROOM_DOESNT_EXIST);
        }
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    // --private methods--
    private Room findRoom(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }

        return null;
    }

    private Room findRoom(Room roomToFind) {
        for (Room room : rooms) {
            if (room.getId() == roomToFind.getId()) {
                return room;
            }
        }

        return null;
    }
}
