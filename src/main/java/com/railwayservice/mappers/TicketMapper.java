package com.railwayservice.mappers;

import com.railwayservice.dto.TicketDto;
import com.railwayservice.model.entity.Ticket;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TicketMapper {
    Ticket ticketDtoToTicket(TicketDto ticketDto);
}
