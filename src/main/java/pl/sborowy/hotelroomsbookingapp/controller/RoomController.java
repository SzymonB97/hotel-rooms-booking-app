package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sborowy.hotelroomsbookingapp.entity.Room;
import pl.sborowy.hotelroomsbookingapp.service.RoomService;
import pl.sborowy.hotelroomsbookingapp.util.AttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.Mappings;
import pl.sborowy.hotelroomsbookingapp.util.ViewNames;

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
    @GetMapping(Mappings.ROOMS)
    public String listRooms(Model model) {
        model.addAttribute(AttributeNames.ROOMS, roomService.findAll());

        return ViewNames.ROOMS_LIST;
    }

    @GetMapping(Mappings.ROOM)
    public String getRoom(@RequestParam("roomId") int id, Model model) {
        Room room = roomService.findById(id);
        model.addAttribute(AttributeNames.ROOM, room);

        return ViewNames.ROOM;
    }

    @GetMapping(Mappings.ROOM_DELETE)
    public String deleteRoom(@RequestParam("roomId") int id) {
        roomService.deleteById(id);

        return "redirect:" + Mappings.ROOMS;
    }

    @GetMapping(Mappings.ROOM_FORM_SAVE)
    public String showFormForSaveRoom(Model model) {
        // model attribute to bind form data
        Room room = new Room();
        model.addAttribute(AttributeNames.ROOM, room);

        return ViewNames.ROOM_FORM;
    }

    @GetMapping(Mappings.ROOM_FORM_UPDATE)
    public String showFormForUpdateRoom(@RequestParam("roomId") int id, Model model) {
        Room room = roomService.findById(id);
        model.addAttribute(AttributeNames.ROOM, room);

        return ViewNames.ROOM_FORM;
    }

    // --post methods--
    @PostMapping(Mappings.ROOM_SAVE)
    public String saveRoom(@ModelAttribute(AttributeNames.ROOM) Room room) {
        roomService.save(room);

        return "redirect:" + Mappings.ROOMS;
    }
}
