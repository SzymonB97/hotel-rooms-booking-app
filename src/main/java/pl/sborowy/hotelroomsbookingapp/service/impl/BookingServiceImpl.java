package pl.sborowy.hotelroomsbookingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sborowy.hotelroomsbookingapp.dao.BookingRepository;
import pl.sborowy.hotelroomsbookingapp.entity.Booking;
import pl.sborowy.hotelroomsbookingapp.service.BookingService;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    // --fields--
    private final BookingRepository bookingRepository;

    // --constructors--
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // --public methods--
    @Override
    public void book(Booking newBooking) {
        bookingRepository.save(newBooking);
    }

    @Override
    public Booking findById(int id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);

        if (optionalBooking.isPresent()) {
            return optionalBooking.get();
        } else {
            throw new NullPointerException("Booking with id " + id + " doesn't exists!");
        }
    }

    @Override
    public void deleteById(int id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
