package com.railwayservice.service;

import com.railwayservice.model.entity.City;

public interface CityService {
    City findCityByName(String name);

    void checkIsCityExist(String name);
}
