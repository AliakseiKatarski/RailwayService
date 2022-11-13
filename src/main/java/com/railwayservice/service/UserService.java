package com.railwayservice.service;

import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.model.entity.User;

import java.util.List;


public interface UserService {
    List<User> findAllUsers();
    void saveUser(UserRegistrationDto userRegistrationDto);
}
