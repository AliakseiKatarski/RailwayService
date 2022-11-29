package com.railwayservice.service.impl;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.mappers.DepartureMapper;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.repository.DepartureRepository;
import com.railwayservice.service.CityService;
import com.railwayservice.service.DepartureService;
import com.railwayservice.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartureServiceImpl implements DepartureService {
    private final DepartureRepository departureRepository;
    private final DepartureMapper departureMapper;
    private final TrainService trainService;
    private final CityService cityService;


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
    public List<DepartureDto> findAllDepartures() {
        return departureRepository.findAll().stream()
                .map(departureMapper::departureToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createNewDeparture(DepartureDto departureDto) {
        Departure departure=departureMapper.departureDtoToDeparture(departureDto);
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
