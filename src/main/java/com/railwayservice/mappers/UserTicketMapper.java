package com.railwayservice.mappers;

import com.railwayservice.dto.UserDepartureDto;
import com.railwayservice.model.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper
public interface UserTicketMapper {
    UserDepartureDto ticketToUserTicketDto(Ticket ticket);

}
