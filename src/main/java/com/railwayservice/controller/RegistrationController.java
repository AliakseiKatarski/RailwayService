package com.railwayservice.controller;
import com.railwayservice.dto.UserRegistrationDto;
import com.railwayservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("user",new UserRegistrationDto());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String userRegistration(@ModelAttribute("user") @Valid UserRegistrationDto user,
                                   BindingResult bindingResult,
                                   Model model){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/registration?success";
    }

}