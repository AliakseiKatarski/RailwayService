package com.railwayservice.service;

import com.railwayservice.dto.UserDepartureDto;
import com.railwayservice.model.entity.Departure;
import java.util.List;

public interface DepartureService {
    List<Departure> showAllDepartures();
    List<Departure> findDeparturesForUser(UserDepartureDto userDepartureDto);
}
