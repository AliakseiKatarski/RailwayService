package com.railwayservice.service;

import com.railwayservice.dto.CreditCardDto;
import com.railwayservice.dto.TicketDto;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllTickets();
    void deleteTicketById(Integer id);
    Ticket findTicketById(Integer id);
    List<Ticket> findUserTickets(String username);
    TicketDto createTicketForUser(Departure departure);
    void saveTicket(TicketDto ticketDto);
    void makePay(TicketDto ticketDto, CreditCardDto creditCardDto);

}
