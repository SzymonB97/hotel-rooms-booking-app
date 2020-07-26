package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sborowy.hotelroomsbookingapp.service.BookingService;
import pl.sborowy.hotelroomsbookingapp.util.booking.BookingAttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.booking.BookingMappings;
import pl.sborowy.hotelroomsbookingapp.util.booking.BookingViewNames;

@Controller
public class BookingController {

    // --fields--
    private final BookingService bookingService;

    // --constructors--
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // --get methods--
    @GetMapping(BookingMappings.BOOKINGS_LIST)
    public String listCustomers(Model model) {
        model.addAttribute(BookingAttributeNames.BOOKINGS, bookingService.findAll());

        return BookingViewNames.BOOKINGS_LIST;
    }
}
