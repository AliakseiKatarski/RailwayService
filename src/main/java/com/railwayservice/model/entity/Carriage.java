package com.railwayservice.model.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Carriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String type;
    @Column(name="seats_number")
    private int seatsNumber;
}
