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


/**
 * Class responsible for administrator functionality
 */

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    /**
     * Return all users from database.Needed to view and delete users.
     */

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    /**
     * Deletes user from database.
     * @param id = user id.
     */

    @Override
    public void deleteUserById(Integer id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
        }
    }

    /**
     * Changing role of user.
     * @param username Username in database.
     * @param roleName {Admin,User}.
     */

    @Override
    public void setNewRole(String username, String roleName) {
       Role role=roleRepository.findByName(roleName);
       User user=userRepository.findUserByUsername(username);
       user.setRole(role);
       userRepository.save(user);
    }

    /**
     * Return all roles from database.Needed to role changing functionality.
     */

    @Override
    public List<RoleDto> findAllRoles() {
        List<Role> roles=roleRepository.findAll();
        return roles.stream()
                .map(roleMapper::roleToDto)
                .collect(Collectors.toList());
    }

}
