package com.railwayservice.service.impl;

import com.railwayservice.exception.CityNotFoundException;
import com.railwayservice.model.entity.City;
import com.railwayservice.model.repository.CityRepository;
import com.railwayservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;


    @Override
    public City findCityByName(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public void checkIsCityExist(String name) {
        City city=cityRepository.findCityByName(name);
        if(city==null){
            throw new CityNotFoundException(name);
        }
    }
}
