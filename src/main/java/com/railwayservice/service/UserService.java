package com.railwayservice.service;
import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.entity.UserInformation;


public interface UserService {
    User findUserByUsername(String username);

    void saveUser(UserRegistrationDto userRegistrationDto);
}
