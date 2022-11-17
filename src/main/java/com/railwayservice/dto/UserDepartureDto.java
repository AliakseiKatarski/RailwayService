package com.railwayservice.dto;

import com.railwayservice.model.entity.Station;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class UserDepartureDto {
    private Station departureStation;
    private Station arrivalStation;
    private LocalDate departureDate;
    private LocalTime departureTime;

}
