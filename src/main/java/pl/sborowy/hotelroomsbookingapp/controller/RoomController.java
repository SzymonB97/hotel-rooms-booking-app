package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    // --request methods--
    @GetMapping(Mappings.ROOMS)
    public String rooms(Model model) {
        model.addAttribute(AttributeNames.ROOMS, roomService.findAll());

        return ViewNames.ROOMS_LIST;
    }
}
