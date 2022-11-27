package com.railwayservice.service;

import com.railwayservice.dto.RoleDto;
import com.railwayservice.dto.UserDto;
import java.util.List;

public interface AdminService {
    List<UserDto> findAllUsers();
    void deleteUserById(Integer id);
    void setNewRole(String username,String role);
    List<RoleDto> findAllRoles();
}
