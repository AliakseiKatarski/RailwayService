package com.railwayservice.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@ToString(of = {"id","name"})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToOne(mappedBy = "city")
    private Station station;
    @OneToMany(mappedBy = "departureCity",cascade = CascadeType.ALL)
    private Set<Departure> departures;
}
