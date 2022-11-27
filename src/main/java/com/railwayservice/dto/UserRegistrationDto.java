package com.railwayservice.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationDto {
    @NotNull(message = "Please enter your login")
    @Size(min = 2,message = "Login cannot be less than 2 characters")
    private String username;
    @NotNull(message = "Password cannot be empty")
    private String password;
    @NotNull(message = "Please enter your name")
    @Size(min = 2,message = "Name cannot be less than 2 characters")
    private String name;
    @NotNull(message = "Please enter your surname")
    @Size(min = 2,message = "Surname cannot be less than 2 characters")
    private String surname;
    @NotNull(message = "Enter your phone number please")
    @Pattern(regexp = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$",message = "Invalid phone number")
    private String phoneNumber;
    @Email(message = "This email is invalid,please enter a valid email")
    private String email;
}
