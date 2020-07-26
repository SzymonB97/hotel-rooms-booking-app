package pl.sborowy.hotelroomsbookingapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@ToString
public class Room {

    // --fields--
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "floor")
    private String floor;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "people_amount")
    private int peopleAmount;

    @Column(name = "cost_per_night")
    private double costPerNight;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    // --constructors--
    public Room() {
    }

    public Room(String floor, String roomNumber, int peopleAmount, double costPerNight) {
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.peopleAmount = peopleAmount;
        this.costPerNight = costPerNight;
    }
}
