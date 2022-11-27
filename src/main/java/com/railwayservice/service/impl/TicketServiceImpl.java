package com.railwayservice.service.impl;

import com.railwayservice.dto.CreditCardDto;
import com.railwayservice.dto.TicketDto;
import com.railwayservice.mappers.TicketMapper;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.Ticket;
import com.railwayservice.model.repository.TicketRepository;
import com.railwayservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

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
    public TicketDto createTicketForUser(Departure departure) {
        TicketDto ticketDto=new TicketDto();
        ticketDto.setDeparture(departure);
        ticketDto.setPrice(departure.getPrice());
        return ticketDto;
    }

    @Override
    public void saveTicket(TicketDto ticketDto) {
        Ticket ticket=ticketMapper.ticketDtoToTicket(ticketDto);
        ticket.setUser(ticketDto.getUser());
        ticketRepository.save(ticket);
    }

    @Override
    public void makePay(TicketDto ticketDto, CreditCardDto creditCardDto) {
        saveTicket(ticketDto);
    }
}
