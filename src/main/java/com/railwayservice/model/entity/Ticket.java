package com.railwayservice.model.entity;

import lombok.Data;
import javax.persistence.*;

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
    @Column
    private double price;
}
