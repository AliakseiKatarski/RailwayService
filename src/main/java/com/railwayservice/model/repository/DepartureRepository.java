package com.railwayservice.model.repository;

import com.railwayservice.model.entity.Departure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DepartureRepository extends JpaRepository<Departure,Integer> {

    @Query("select d from Departure d where d.departureCity.name =:departureCity and d.arrivalCity.name=:arrivalCity " +
            "and d.departureTime>:departureTime and d.departureDate>=:departureDate" )
    List<Departure> findDepartureForUser(String departureCity, String arrivalCity,
                                         LocalTime departureTime, LocalDate departureDate);
}
