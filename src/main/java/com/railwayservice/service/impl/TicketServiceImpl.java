package com.railwayservice.service.impl;

import com.railwayservice.dto.UserDepartureDto;
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

    @Override
    public void deleteTicketById(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket findTicketById(Integer id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> findUserTickets(String username) {
        List<Ticket> userTickets=ticketRepository.findByUser_username(username);
        return userTickets;
    }

    @Override
    public Ticket findTicketForUser(UserDepartureDto userTicketDto) {
        return null;

    }
}
