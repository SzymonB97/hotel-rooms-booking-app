package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sborowy.hotelroomsbookingapp.entity.Room;
import pl.sborowy.hotelroomsbookingapp.service.RoomService;
import pl.sborowy.hotelroomsbookingapp.util.room.RoomAttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.room.RoomMappings;
import pl.sborowy.hotelroomsbookingapp.util.room.RoomViewNames;

@Controller
public class RoomController {

    // --fields--
    private final RoomService roomService;

    // --constructors--
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // --get methods--
    @GetMapping(RoomMappings.ROOMS_LIST)
    public String listRooms(Model model) {
        model.addAttribute(RoomAttributeNames.ROOMS, roomService.findAll());

        return RoomViewNames.ROOMS_LIST;
    }

    @GetMapping(RoomMappings.ROOM_GET)
    public String getRoom(@RequestParam(RoomAttributeNames.ROOM_ID) int id, Model model) {
        Room room = roomService.findById(id);
        model.addAttribute(RoomAttributeNames.ROOM, room);

        return RoomViewNames.ROOM;
    }

    @GetMapping(RoomMappings.ROOM_DELETE)
    public String deleteRoom(@RequestParam(RoomAttributeNames.ROOM_ID) int id) {
        roomService.deleteById(id);

        return "redirect:" + RoomMappings.ROOMS_LIST;
    }

    @GetMapping(RoomMappings.ROOM_FORM_SAVE)
    public String showFormForSaveRoom(Model model) {
        // model attribute to bind form data
        Room room = new Room();
        model.addAttribute(RoomAttributeNames.ROOM, room);

        return RoomViewNames.ROOM_FORM;
    }

    @GetMapping(RoomMappings.ROOM_FORM_UPDATE)
    public String showFormForUpdateRoom(@RequestParam(RoomAttributeNames.ROOM_ID) int id, Model model) {
        Room room = roomService.findById(id);
        model.addAttribute(RoomAttributeNames.ROOM, room);

        return RoomViewNames.ROOM_FORM;
    }

    // --post methods--
    @PostMapping(RoomMappings.ROOM_SAVE)
    public String saveRoom(@ModelAttribute(RoomAttributeNames.ROOM) Room room) {
        roomService.save(room);

        return "redirect:" + RoomMappings.ROOMS_LIST;
    }
}
