package pl.sborowy.hotelroomsbookingapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Customer {

    // --fields--
    private int id;
    private String firstName;
    private String lastName;

    // --constructors--
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
