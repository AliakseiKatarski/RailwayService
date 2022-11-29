package com.railwayservice.service;

import com.railwayservice.model.entity.Train;

public interface TrainService {
    Train findByTrainName(String trainName);

}
