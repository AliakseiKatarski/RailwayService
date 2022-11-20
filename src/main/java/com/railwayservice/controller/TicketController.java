package com.railwayservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    @GetMapping(value = "/order")
    public String order(){
        return "ticket";
    }
}
