package com.railwayservice.dto;

import lombok.Data;
import java.util.Set;

@Data
public class TrainDto {
    private Integer id;
    private int number;
    private String name;
    private Set<DepartureDto> departures;
}
