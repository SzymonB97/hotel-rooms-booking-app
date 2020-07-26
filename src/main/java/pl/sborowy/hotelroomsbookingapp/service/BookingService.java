package pl.sborowy.hotelroomsbookingapp.service;

import lombok.NonNull;
import pl.sborowy.hotelroomsbookingapp.entity.Booking;

import java.util.List;

public interface BookingService {

    void book(@NonNull Booking newBooking);

    Booking findById(int id);

    void deleteById(int id);

    List<Booking> findAll();
}
