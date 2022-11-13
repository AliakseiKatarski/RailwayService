package com.railwayservice.controller;
import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("user",new UserRegistrationDto());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String userRegistration(@Valid @ModelAttribute("user") UserRegistrationDto user, Model model){
        userService.saveUser(user);
        return "redirect:/registration?success";
    }

}