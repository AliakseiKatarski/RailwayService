package com.railwayservice.controller;

import com.railwayservice.dto.UserDepartureDto;
import com.railwayservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DepartureController {

    private final TicketService ticketService;

    @GetMapping(value = "/departure")
    public String tickets(Model model){
        model.addAttribute("userTicket",new UserDepartureDto());
        return "departure";
    }

    @PostMapping(value = "/tickets")
    public String findDepartures(@ModelAttribute("userTicket") UserDepartureDto userTicketDto, Model model){



        return "ticket";
    }




}
