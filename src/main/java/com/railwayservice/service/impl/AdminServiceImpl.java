package com.railwayservice.service.impl;

import com.railwayservice.dto.RoleDto;
import com.railwayservice.dto.UserDto;
import com.railwayservice.mappers.RoleMapper;
import com.railwayservice.mappers.UserMapper;
import com.railwayservice.model.entity.Role;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.repository.RoleRepository;
import com.railwayservice.model.repository.UserRepository;
import com.railwayservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Integer id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
        }
    }

    @Override
    public void setNewRole(String username, String roleName) {
       Role role=roleRepository.findByName(roleName);
       User user=userRepository.findUserByUsername(username);
       user.setRole(role);
       userRepository.save(user);
    }

    @Override
    public List<RoleDto> findAllRoles() {
        List<Role> roles=roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::roleToDto)
                .collect(Collectors.toList());
    }

}
