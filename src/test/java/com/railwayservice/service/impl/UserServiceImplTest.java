package com.railwayservice.service.impl;

import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.mappers.UserRegistrationDtoMapper;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.Role;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.entity.UserInformation;
import com.railwayservice.model.repository.RoleRepository;
import com.railwayservice.model.repository.UserInformationRepository;
import com.railwayservice.model.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private UserRegistrationDtoMapper registrationDtoMapper;
    @Mock
    private UserInformationRepository informationRepository;
    @Mock
    private PasswordEncoder encoder;

    @Test
    void findUserByUsername() {
        String username = "Test";
        User result = new User();
        result.setUsername("Test");
        when(userRepository.findUserByUsername(username)).thenReturn(result);
        Assertions.assertEquals(result, userService.findUserByUsername(username));
        verify(userRepository, times(1)).findUserByUsername(username);
    }




}