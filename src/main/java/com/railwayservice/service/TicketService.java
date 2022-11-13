package com.railwayservice.service;

import com.railwayservice.model.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAllTickets();
}
