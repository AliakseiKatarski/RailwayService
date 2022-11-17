package com.railwayservice.dto;

import com.railwayservice.model.entity.Station;
import com.railwayservice.model.entity.Train;

import java.time.LocalDateTime;

public class TicketDto {
    private Integer id;
    private String username;
    private Train trainName;
    private Station departureStation;
    private LocalDateTime departureDate;
    private Station arrivalStation;
    private LocalDateTime arrivalDate;
    private Integer carriageNumber;
    private Double price;
}
