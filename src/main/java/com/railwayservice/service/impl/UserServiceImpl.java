package com.railwayservice.service.impl;

import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.mappers.UserRegistrationDtoMapper;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.entity.UserInformation;
import com.railwayservice.model.repository.RoleRepository;
import com.railwayservice.model.repository.UserInformationRepository;
import com.railwayservice.model.repository.UserRepository;
import com.railwayservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRegistrationDtoMapper registrationDtoMapper;
    private final UserInformationRepository informationRepository;
    private final PasswordEncoder encoder;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void saveUser(UserRegistrationDto userRegistrationDto) {
        User user=registrationDtoMapper.userRegistrationDtoToUser(userRegistrationDto);
        user.setPassword(encoder.encode(userRegistrationDto.getPassword()));
        user.setRole(roleRepository.findByName("ROLE_USER"));
        UserInformation userInfo=registrationDtoMapper.userRegistrationDtoToUserInformation(userRegistrationDto);
        userInfo.setUser(user);
        informationRepository.save(userInfo);
        userRepository.save(user);
    }


}
