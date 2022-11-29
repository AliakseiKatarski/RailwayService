package com.railwayservice.model.repository;

import com.railwayservice.model.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {
    Train findByName(String name);
}
