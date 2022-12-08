package com.railwayservice.service.impl;

import com.railwayservice.dto.DepartureDto;
import com.railwayservice.dto.UserDto;
import com.railwayservice.mappers.DepartureMapper;
import com.railwayservice.model.entity.Departure;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.repository.DepartureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class DepartureServiceImplTest {

    @InjectMocks
    private DepartureServiceImpl departureService;
    @Mock
    private DepartureRepository departureRepository;
    @Mock
    private DepartureMapper departureMapper;


    @Test
    void findDepartureById() {
        Integer id = 10;
        Departure result = new Departure();
        result.setId(id);
        when(departureRepository.findById(id)).thenReturn(Optional.of(result));
        Assertions.assertEquals(result, departureService.findDepartureById(id));
        verify(departureRepository, times(1)).findById(id);
    }


    @Test
    void findAllDepartures() {
        Departure firstDeparture = new Departure();
        firstDeparture.setId(1);
        Departure secondDeparture = new Departure();
        secondDeparture.setId(2);

        List<Departure> departures = List.of(firstDeparture, secondDeparture);

        when(departureRepository.findAll()).thenReturn(departures);
        DepartureDto firstDepartureDto = new DepartureDto();
        firstDepartureDto.setId(1);
        DepartureDto secondDepartureDto = new DepartureDto();
        secondDepartureDto.setId(2);

        List<DepartureDto> result = List.of(firstDepartureDto,secondDepartureDto);

        when(departureMapper.departureToDto(firstDeparture)).thenReturn(firstDepartureDto);
        when(departureMapper.departureToDto(secondDeparture)).thenReturn(secondDepartureDto);

        assertEquals(result,departureService.findAllDepartures());

        verify(departureRepository, times(1)).findAll();
        verify(departureMapper, times(1)).departureToDto(firstDeparture);
        verify(departureMapper, times(1)).departureToDto(secondDeparture);
    }

    @Test
    void deleteById() {
        Integer departureId = 1;

        departureService.deleteById(departureId);

        verify(departureRepository, times(1)).deleteById(departureId);
    }
}