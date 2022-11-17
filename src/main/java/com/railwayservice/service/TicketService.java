package com.railwayservice.service;

import com.railwayservice.dto.UserDepartureDto;
import com.railwayservice.model.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllTickets();
    void deleteTicketById(Integer id);
    Ticket findTicketById(Integer id);
    List<Ticket> findUserTickets(String username);
    Ticket findTicketForUser(UserDepartureDto userTicketDto);

}
