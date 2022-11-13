package com.railwayservice.model.entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@ToString(of = {"id","username","password","role","userInformation"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private UserInformation userInformation;

}
