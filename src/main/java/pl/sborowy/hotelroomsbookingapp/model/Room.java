package pl.sborowy.hotelroomsbookingapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Room {

    // --fields--
    private int id;
    private String number;
    private String numberOfPeople;
    private double costPerDay;
    private boolean isAvailable;

    // --constructors--
    public Room(String number, String numberOfPeople, double costPerDay) {
        this.number = number;
        this.numberOfPeople = numberOfPeople;
        this.costPerDay = costPerDay;
        this.isAvailable = true;
    }
}
