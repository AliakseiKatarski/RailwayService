package com.railwayservice.service;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.model.entity.Departure;
import java.util.List;

public interface DepartureService {
    Departure findDepartureById(Integer id);

    List<Departure> findDepartureForUser(DepartureDto departureDto);

    List<DepartureDto> findAllDepartures();

    void createNewDeparture(DepartureDto departure);

    void deleteById(Integer id);






}
