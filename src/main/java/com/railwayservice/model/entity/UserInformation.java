package com.railwayservice.model.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@ToString(of = {"id","name","surname","phoneNumber","email"})
public class UserInformation {
    @Id
    private Integer id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column
    private String email;
}
