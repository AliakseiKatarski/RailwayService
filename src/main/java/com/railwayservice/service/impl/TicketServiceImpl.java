package com.railwayservice.service.impl;

import com.railwayservice.dto.CreditCardDto;
import com.railwayservice.dto.TicketDto;
import com.railwayservice.mappers.TicketMapper;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.Ticket;
import com.railwayservice.model.repository.TicketRepository;
import com.railwayservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class responsible for creating a ticket for the user based on his departure.
 *
 */

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    /**
     * @return All tickets from database.
     */

    @Override
    public List<TicketDto> findAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketMapper::ticketToDto)
                .collect(Collectors.toList());
    }

    /**
     * Delete ticket from database.
     * @param id Ticket id.
     */

    @Override
    public void deleteTicketById(Integer id) {
        try {
            ticketRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
        }

    }

    /**
     * @param id Ticket id.
     * @return Ticket with current id from database.
     */

    @Override
    public Ticket findTicketById(Integer id) {
        return ticketRepository.findById(id).get();
    }

    /**
     * @param username Username in database.
     * @return All purchased user tickets.
     */

    @Override
    public List<TicketDto> findUserTickets(String username) {
        return ticketRepository.findByUser_username(username).stream()
                .map(ticketMapper::ticketToDto)
                .collect(Collectors.toList());

    }

    /**
     * Method fills TicketDto with data from Departure.
     * @param departure contains data about departure.
     * @return TicketDto witch has data from Departure.
     */

    @Override
    public TicketDto createTicketForUser(Departure departure) {
        TicketDto ticketDto=new TicketDto();
        ticketDto.setDeparture(departure);
        ticketDto.setPrice(departure.getPrice());
        return ticketDto;
    }

    /**
     * Save Ticket in database.
     * @param ticketDto contains data.
     */

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
