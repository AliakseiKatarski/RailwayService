package com.railwayservice.service;

import com.railwayservice.dto.RoleDto;
import com.railwayservice.dto.UserDto;
import java.util.List;

public interface AdminService {
    List<UserDto> findAllUsers();
    UserDto findUserById(Integer id);
    void deleteUserById(Integer id);
    void updateUser(UserDto userDto);
    void setNewRole(String username,String role);
    List<RoleDto> findAllRoles();

}
