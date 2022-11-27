package com.railwayservice.model.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(of = {"id","train","departureTime","arrivalTime"})
@ToString(of = {"id","departureTime","arrivalTime"})
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="route_type_id")
    private Route route;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_city_id")
    private City departureCity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="arrival_city_id")
    private City arrivalCity;
    @Column(name = "departure_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departureTime;
    @Column(name="arrival_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime arrivalTime;
    @Column(name = "arrival_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate arrivalDate;
    @Column(name = "departure_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
    @Column(name="price")
    private double price;
    @OneToMany(mappedBy = "departure",cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
