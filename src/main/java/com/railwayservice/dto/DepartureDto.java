package com.railwayservice.dto;

import com.railwayservice.model.entity.Train;
import lombok.Data;

@Data
public class DepartureDto {
    private Integer id;
    private Train train;

}
