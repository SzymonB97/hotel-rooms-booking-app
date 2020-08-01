package pl.sborowy.hotelroomsbookingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sborowy.hotelroomsbookingapp.entity.Booking;
import pl.sborowy.hotelroomsbookingapp.entity.Customer;
import pl.sborowy.hotelroomsbookingapp.entity.Room;
import pl.sborowy.hotelroomsbookingapp.service.BookingService;
import pl.sborowy.hotelroomsbookingapp.service.CustomerService;
import pl.sborowy.hotelroomsbookingapp.service.RoomService;
import pl.sborowy.hotelroomsbookingapp.util.booking.BookingAttributeNames;
import pl.sborowy.hotelroomsbookingapp.util.booking.BookingMappings;
import pl.sborowy.hotelroomsbookingapp.util.booking.BookingViewNames;
import pl.sborowy.hotelroomsbookingapp.util.room.RoomAttributeNames;

@Controller
public class BookingController {

    // --fields--
    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;

    // --constructors--
    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
    }

    // --get methods--
    @GetMapping(BookingMappings.BOOKINGS_LIST)
    public String listCustomers(Model model) {
        model.addAttribute(BookingAttributeNames.BOOKINGS, bookingService.findAll());

        return BookingViewNames.BOOKINGS_LIST;
    }

    // have to be change!!!
    @GetMapping(BookingMappings.BOOKING_FORM_SAVE)
    public String showFormForBookRoom(@RequestParam(RoomAttributeNames.ROOM_ID) int roomId, Model model) {
        Room room = roomService.findById(roomId);

        if (room != null) {
            Booking booking = new Booking();
            Customer tempCustomer = new Customer();
            Room tempRoom = new Room();
            tempRoom.setId(roomId);

            booking.setCustomer(tempCustomer);
            booking.setRoom(tempRoom);
            model.addAttribute(BookingAttributeNames.BOOKING, booking);

            return BookingViewNames.BOOKING_FORM;
        } else {
            throw new NullPointerException("Room cannot be null!!!");
        }
    }

    // --post methods--

    // have to be change!!!
    @PostMapping(BookingMappings.BOOKING_SAVE)
    public String bookRoom(@ModelAttribute(BookingAttributeNames.BOOKING) Booking booking) {
        Customer tempCustomer = booking.getCustomer();
        Room tempRoom = booking.getRoom();

        Customer customerDb = customerService.findFirstByFirstNameAndLastName(tempCustomer.getFirstName(), tempCustomer.getLastName());
        Room roomDb = roomService.findById(tempRoom.getId());

        booking.setCustomer(customerDb);
        booking.setRoom(roomDb);
        bookingService.book(booking);

        return "redirect:" + BookingMappings.BOOKINGS_LIST;
    }
}
