package com.railwayservice.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(of = {"id","number","name"})
@ToString(of = {"id","number","name"})
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int number;
    @Column
    private String name;
    @OneToMany(mappedBy = "train")
    private Set<Departure> departures;
}
