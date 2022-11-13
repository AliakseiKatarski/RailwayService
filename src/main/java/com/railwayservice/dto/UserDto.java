package com.railwayservice.dto;
import com.railwayservice.model.entity.Role;
import lombok.Data;


@Data
public class UserDto {
    private Integer id;
    private String username;
    private Role role;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}
