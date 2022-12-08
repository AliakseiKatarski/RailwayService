package com.railwayservice.service.impl;

import com.railwayservice.model.entity.Train;
import com.railwayservice.model.entity.User;
import com.railwayservice.model.repository.TrainRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TrainServiceImplTest {
    @InjectMocks
    private TrainServiceImpl trainService;
    @Mock
    private TrainRepository trainRepository;

    @Test
    void findByTrainName() {
        String trainName = "Train";
        Train result = new Train();
        result.setName("Train");
        when(trainRepository.findByName(trainName)).thenReturn(result);
        Assertions.assertEquals(result, trainService.findByTrainName(trainName));
        verify(trainRepository, times(1)).findByName(trainName);

    }
}