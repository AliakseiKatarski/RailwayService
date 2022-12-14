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
    @OneToMany(mappedBy = "departureCity",cascade = CascadeType.MERGE)
    private Set<Departure> departures;
}
