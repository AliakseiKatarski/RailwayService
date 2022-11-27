package com.railwayservice.controller;

import com.railwayservice.dto.CreditCardDto;
import com.railwayservice.dto.TicketDto;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.User;
import com.railwayservice.service.DepartureService;
import com.railwayservice.service.TicketService;
import com.railwayservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class OrderController {
    private final DepartureService departureService;
    private final TicketService ticketService;
    private final UserService userService;

    @GetMapping(value = "/order")
    public String route(@RequestParam Integer departureId, Model model, Principal principal,
                        HttpSession session) {
        Departure departure=departureService.findDepartureById(departureId);
        User user=userService.findUserByUsername(principal.getName());
        TicketDto ticket=ticketService.createTicketForUser(departure);
        ticket.setUser(user);
        model.addAttribute("departure",departure);
        model.addAttribute("ticket",ticket);
        model.addAttribute("card",new CreditCardDto());
        session.setAttribute("ticket",ticket);

        return "order";

    }

    @PostMapping(value = "/order/do-order")
    public String makeOrder(@SessionAttribute("ticket") TicketDto ticketDto,
                             @ModelAttribute("card") @Valid CreditCardDto cardDto, BindingResult bindingResult,
                            Model model){
        if(bindingResult.hasErrors()){

            return "order";
        }

        ticketService.makePay(ticketDto,cardDto);
        model.addAttribute("purchasedTicket",ticketDto);
        return "order-success";
    }
}
