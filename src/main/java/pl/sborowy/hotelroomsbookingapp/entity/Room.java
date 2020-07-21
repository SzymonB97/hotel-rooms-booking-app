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

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "people_amount")
    private int peopleAmount;

    @Column(name = "rental_cost")
    private double rentalCost;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "bookings",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers;

    // --constructors--
    public Room() {
    }

    public Room(String roomNumber, int peopleAmount, double rentalCost) {
        this.roomNumber = roomNumber;
        this.peopleAmount = peopleAmount;
        this.rentalCost = rentalCost;
    }
}
