package com.railwayservice.service.impl;

import com.railwayservice.model.entity.Train;
import com.railwayservice.model.repository.TrainRepository;
import com.railwayservice.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;


    @Override
    public Train findByTrainName(String trainName) {
        return trainRepository.findByName(trainName);
    }
}
