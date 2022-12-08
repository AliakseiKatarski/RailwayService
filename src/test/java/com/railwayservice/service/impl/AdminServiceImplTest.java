package com.railwayservice.service.impl;

import com.railwayservice.dto.UserDto;
import com.railwayservice.mappers.RoleMapper;
import com.railwayservice.mappers.UserMapper;
import com.railwayservice.model.entity.Role;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.repository.RoleRepository;
import com.railwayservice.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AdminServiceImplTest {
    @InjectMocks
    private AdminServiceImpl adminService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private RoleMapper roleMapper;

    @Test
    void findAllUsers() {
        User firstUser = new User();
        firstUser.setUsername("admin");
        User secondUser = new User();
        secondUser.setUsername("user");

        List<User> users = List.of(firstUser, secondUser);

        when(userRepository.findAll()).thenReturn(users);
        UserDto firstUserDto = new UserDto();
        firstUserDto.setUsername("admin");
        UserDto secondUserDto = new UserDto();
        secondUserDto.setUsername("user");

        when(userMapper.userToDto(firstUser)).thenReturn(firstUserDto);
        when(userMapper.userToDto(secondUser)).thenReturn(secondUserDto);
        List<UserDto> result = List.of(firstUserDto, secondUserDto);
        assertEquals(result, adminService.findAllUsers());

        verify(userRepository, times(1)).findAll();
        verify(userMapper, times(users.size())).userToDto(any(User.class));

    }

    @Test
    void deleteUserById() {
        Integer id=1;
        adminService.deleteUserById(id);
        verify(userRepository,times(1)).deleteById(id);
    }

    @Test
    void setNewRole() {
        String username = "user";
        String newRoleName = "ROLE_ADMIN";

        Role newRole = new Role();
        newRole.setName(newRoleName);

        when(roleRepository.findByName(newRoleName)).thenReturn(newRole);

        Role oldRole = new Role();
        oldRole.setName("ROLE_USER");

        User user = new User();
        user.setUsername(username);
        user.setRole(oldRole);

        when(userRepository.findUserByUsername(username)).thenReturn(user);

        adminService.setNewRole(username, newRoleName);

        assertEquals(newRole, user.getRole());

        verify(roleRepository, times(1)).findByName(newRoleName);
        verify(userRepository, times(1)).findUserByUsername(username);
        verify(userRepository, times(1)).save(user);

    }

    @Test
    void findAllRoles() {
        Role role = new Role();
        role.setId(10);

        List<Role> roles = List.of(role);

        when(roleRepository.findAll()).thenReturn(roles);
    }
}