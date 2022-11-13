package com.railwayservice.model.repository;

import com.railwayservice.model.entity.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartureRepository extends JpaRepository<Departure,Integer> {
}
