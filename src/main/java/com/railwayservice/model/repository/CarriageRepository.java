package com.railwayservice.model.repository;

import com.railwayservice.model.entity.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageRepository extends JpaRepository<Carriage,Integer> {
}
