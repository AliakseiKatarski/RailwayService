package com.railwayservice.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="departure_id")
    private Departure departure;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="departure_station_id")
    private Station departureStation;
    @Column(name="departure_time")
    private LocalDateTime departureTime;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "arrival_station_id")
    private Station arrivalStation;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @Column(name = "carriage_number")
    private int carriageNumber;
    @Column(name="seat_number")
    private int seatNumber;
    @Column
    private double price;
}
