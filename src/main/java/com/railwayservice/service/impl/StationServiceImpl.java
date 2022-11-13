package com.railwayservice.service.impl;

import com.railwayservice.model.entity.Station;
import com.railwayservice.model.repository.StationRepository;
import com.railwayservice.service.StationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor

public class StationServiceImpl implements StationService {
    private StationRepository stationRepository;

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
