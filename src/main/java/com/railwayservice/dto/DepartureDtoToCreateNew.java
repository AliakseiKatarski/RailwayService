package com.railwayservice.dto;

import com.railwayservice.model.entity.City;
import com.railwayservice.model.entity.Route;
import com.railwayservice.model.entity.Train;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartureDtoToCreateNew {

    private Integer id;
    private Train train;
    private Route route;
    private City departureCity;
    private City arrivalCity;
    private LocalTime departureTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime arrivalTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate arrivalDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
    private double price;

}
