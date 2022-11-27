package com.railwayservice.controller;
import com.railwayservice.dto.RoleDto;
import com.railwayservice.dto.UserDto;
import com.railwayservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;


    @GetMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping(value = "/admin/users")
    public String users(Model model) {
        List<UserDto> users = adminService.findAllUsers();
        model.addAttribute("users", users);
        return "admin-users";
    }

    @PostMapping(value = "/admin", params = {"hiddenAction=deleteUser"})
    public String deleteUser(@RequestParam("userId") Integer userId, Model model) {
        adminService.deleteUserById(userId);
        setModelData(model);
        return "admin-users";
    }

    @PostMapping(value = "/admin",params = {"hiddenAction=changeUserRole"})
    public String changeRole(@RequestParam("username") String username,
                             @RequestParam("newRole") String newRole,Model model){
        adminService.setNewRole(username,newRole);
        setModelData(model);
        return "admin-users";
    }

    private void setModelData(Model model) {
        List<UserDto> users = adminService.findAllUsers();
        model.addAttribute("users", users);
        List<RoleDto> roles=adminService.findAllRoles();
        model.addAttribute("roles",roles);

    }

}
