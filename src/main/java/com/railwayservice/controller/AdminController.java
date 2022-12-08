package com.railwayservice.controller;
import com.railwayservice.dto.DepartureDto;
import com.railwayservice.dto.RoleDto;
import com.railwayservice.dto.UserDto;
import com.railwayservice.service.AdminService;
import com.railwayservice.service.DepartureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final DepartureService departureService;


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

    @GetMapping(value = "/admin/departures")
    public String departures(Model model){
        List<DepartureDto> departures =departureService.findAllDepartures();
        model.addAttribute("departures",departures);
        return "admin-departures";
    }

    @GetMapping(value = "/admin/departures/new")
    public String newDeparture(Model model){
        DepartureDto departure=new DepartureDto();
        model.addAttribute("newDeparture",departure);
        return "admin-departures-new";
    }

    @PostMapping(value = "/admin/departures/new")
    public String createNewDeparture(@ModelAttribute("newDeparture") DepartureDto departureDto,Model model){
        departureService.createNewDeparture(departureDto);
        setModelData(model);
        return "admin-departures";
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

    @PostMapping(value = "/admin/departures",params = {"hiddenAction=deleteDeparture"})
    public String deleteDeparture(@RequestParam("departureId") Integer departureId,Model model){
        departureService.deleteById(departureId);
        setModelData(model);
        return "admin-departures";
    }

    private void setModelData(Model model) {
        List<UserDto> users = adminService.findAllUsers();
        model.addAttribute("users", users);
        List<RoleDto> roles=adminService.findAllRoles();
        model.addAttribute("roles",roles);
        List<DepartureDto> departures=departureService.findAllDepartures();
        model.addAttribute("departures",departures);

    }

}
