package pl.sborowy.hotelroomsbookingapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private int id;
    private String number;
    private String numberOfPeople;
    private double costPerDay;
    private boolean isAvailable = true;
}
