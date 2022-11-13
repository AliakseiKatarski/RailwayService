package com.railwayservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    @GetMapping(value = "/user")
    public String user(@AuthenticationPrincipal UserDetails userDetails, Model model){
        model.addAttribute("username",userDetails.getUsername());
        return "user";
    }

}
