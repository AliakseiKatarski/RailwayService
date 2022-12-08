package com.railwayservice.service.impl;

import com.railwayservice.dto.TicketDto;
import com.railwayservice.mappers.TicketMapper;
import com.railwayservice.model.entity.Ticket;
import com.railwayservice.model.repository.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TicketServiceImplTest {
    @InjectMocks
    private TicketServiceImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private TicketMapper ticketMapper;

    @Test
    void findAllTickets() {
        Ticket firstTicket = new Ticket();
        firstTicket.setId(1);
        Ticket secondTicket = new Ticket();
        secondTicket.setId(2);

        List<Ticket> departures = List.of(firstTicket, secondTicket);

        when(ticketRepository.findAll()).thenReturn(departures);
        TicketDto firstTicketDto = new TicketDto();
        firstTicketDto.setId(1);
        TicketDto secondTicketDto = new TicketDto();
        secondTicketDto.setId(2);

        List<TicketDto> result = List.of(firstTicketDto,secondTicketDto);

        when(ticketMapper.ticketToDto(firstTicket)).thenReturn(firstTicketDto);
        when(ticketMapper.ticketToDto(secondTicket)).thenReturn(secondTicketDto);

        assertEquals(result,ticketService.findAllTickets());

        verify(ticketRepository, times(1)).findAll();
        verify(ticketMapper, times(1)).ticketToDto(firstTicket);
        verify(ticketMapper, times(1)).ticketToDto(secondTicket);
    }

    @Test
    void deleteTicketById() {
        Integer ticketId = 1;

        ticketService.deleteTicketById(ticketId);

        verify(ticketRepository, times(1)).deleteById(ticketId);
    }

    @Test
    void findTicketById() {
        Integer id = 10;
        Ticket result = new Ticket();
        result.setId(id);
        when(ticketRepository.findById(id)).thenReturn(Optional.of(result));
        Assertions.assertEquals(result, ticketService.findTicketById(id));
        verify(ticketRepository, times(1)).findById(id);

    }

    @Test
    void findUserTickets() {
        String username = "user";

        Ticket ticket = new Ticket();
        ticket.setId(1);

        List<Ticket> tickets = List.of(ticket);

        when(ticketRepository.findByUser_username(username)).thenReturn(tickets);

        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(1);

        when(ticketMapper.ticketToDto(ticket)).thenReturn(ticketDto);

        List<TicketDto> result = List.of(ticketDto);

        assertEquals(result, ticketService.findUserTickets(username));

        verify(ticketRepository, times(1)).findByUser_username(username);
        verify(ticketMapper, times(1)).ticketToDto(ticket);
    }

}