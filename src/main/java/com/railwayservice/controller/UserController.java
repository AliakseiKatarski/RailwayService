package com.railwayservice.controller;

import com.railwayservice.dto.TicketDto;
import com.railwayservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final TicketService ticketService;

    @GetMapping(value = "/user")
    public String user(){
        return "user";
    }

    @GetMapping(value = "/user/tickets")
    public String tickets(Principal principal, Model model){
        List<TicketDto> ticketDto=ticketService.findUserTickets(principal.getName());
        model.addAttribute("tickets",ticketDto);
        return "user-tickets";
    }

    @PostMapping(value = "/user/tickets", params = {"hiddenAction=deleteTicket"})
    public String deleteTicket(@RequestParam("ticketId") Integer ticketId, Model model) {
        ticketService.deleteTicketById(ticketId);
        setModelData(model);
        return "user-tickets";
    }


    private void setModelData(Model model) {
        List<TicketDto> tickets = ticketService.findAllTickets();
        model.addAttribute("tickets", tickets);

    }

}
