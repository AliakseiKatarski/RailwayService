package com.railwayservice.model.entity;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Data
@Entity
@ToString(of = {"id","name"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name")
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<User> users;

}

