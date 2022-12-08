package com.railwayservice.service.impl;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.mappers.DepartureMapper;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.repository.DepartureRepository;
import com.railwayservice.service.DepartureService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class responsible for finding departures for user,creating new departures,deleting exist departures.
 */

@Service
@RequiredArgsConstructor
public class DepartureServiceImpl implements DepartureService {
    private final DepartureRepository departureRepository;

    private final DepartureMapper departureMapper;

    /**
     * @param id Departure id.
     * @return Departure with current id.
     */

    @Override
    public Departure findDepartureById(Integer id) {
        return departureRepository.findById(id).get();
    }

    /**
     * Method responsible for finding departures for user.
     * @param departureDto contains Departure city,Arrival city,Departure time,Departure date.
     * @return suitable departure.
     */

    @Override
    public List<Departure> findDepartureForUser(DepartureDto departureDto) {
        List<Departure> departures=departureRepository.findDepartureForUser(departureDto.getDepartureCity(),
                departureDto.getArrivalCity(),departureDto.getDepartureTime(),departureDto.getDepartureDate());
        return departures;
    }

    /**
     * @return All departures from database.
     */

    @Override
    public List<DepartureDto> findAllDepartures() {
        return departureRepository.findAll().stream()
                .map(departureMapper::departureToDto)
                .collect(Collectors.toList());
    }

    /**
     * Creating new Departure.
     * @param departureDto contains data to create new Departure.
     */

    @Override
    public void createNewDeparture(DepartureDto departureDto) {
        Departure departure=departureMapper.departureDtoToDeparture(departureDto);
        departureRepository.save(departure);

    }

    /**
     * Delete Departure from database.
     * @param id Departure id.
     */

    @Override
    public void deleteById(Integer id) {
        try {
            departureRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
        }
    }
}
