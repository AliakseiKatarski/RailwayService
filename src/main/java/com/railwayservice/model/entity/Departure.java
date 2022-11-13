package com.railwayservice.model.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(of = {"id","train","route","departureTime","arrivalTime"})
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
    private LocalDateTime departureTime;
    @Column(name="arrival_time")
    private LocalDateTime arrivalTime;
}