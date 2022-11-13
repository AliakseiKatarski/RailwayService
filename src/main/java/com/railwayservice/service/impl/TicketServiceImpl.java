package com.railwayservice.service.impl;

import com.railwayservice.model.entity.Ticket;
import com.railwayservice.model.repository.TicketRepository;
import com.railwayservice.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }
}
