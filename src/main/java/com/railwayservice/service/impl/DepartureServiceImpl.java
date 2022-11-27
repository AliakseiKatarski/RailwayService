package com.railwayservice.service.impl;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.repository.DepartureRepository;
import com.railwayservice.service.DepartureService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartureServiceImpl implements DepartureService {
    private final DepartureRepository departureRepository;


    @Override
    public Departure findDepartureById(Integer id) {
        return departureRepository.findById(id).get();
    }

    @Override
    public List<Departure> findDepartureForUser(DepartureDto departureDto) {
        List<Departure> departures=departureRepository.findDepartureForUser(departureDto.getDepartureCity(),
                departureDto.getArrivalCity(),departureDto.getDepartureTime(),departureDto.getDepartureDate());
        return departures;
    }

    @Override
    public List<Departure> findAllDepartures() {
        return departureRepository.findAll();
    }

    @Override
    public void createNewDeparture(Departure departure) {
        departureRepository.save(departure);
    }

    @Override
    public void deleteById(Integer id) {
        try {
            departureRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
        }
    }
}
