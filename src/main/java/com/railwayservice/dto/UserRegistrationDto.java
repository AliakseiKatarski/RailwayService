package com.railwayservice.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserRegistrationDto {
    @Size(min = 2,message = "Your name invalid")
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}
