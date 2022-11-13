package com.railwayservice.model.entity;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "route_type")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String type;
}
