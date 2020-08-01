package pl.sborowy.hotelroomsbookingapp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@ToString
public class Booking {

    // --fields--
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // --constructors--
    public Booking() {
    }

    public Booking(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
