package com.railwayservice.dto;

import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.User;
import lombok.Data;


@Data
public class TicketDto {
    private Integer id;
    private User user;
    private Departure departure;
    private double price;
}
