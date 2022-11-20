package com.railwayservice.service;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.model.entity.Departure;
import java.util.List;

public interface DepartureService {
    void deleteDepartureById(Integer id);
    Departure findDepartureById(Integer id);
    List<Departure> findDepartureForUser(DepartureDto departureDto);





}
