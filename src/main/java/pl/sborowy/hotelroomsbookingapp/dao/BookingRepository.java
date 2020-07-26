package pl.sborowy.hotelroomsbookingapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sborowy.hotelroomsbookingapp.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
