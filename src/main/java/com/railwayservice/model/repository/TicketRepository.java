package com.railwayservice.model.repository;
import com.railwayservice.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByUser_username(String username);
    @Query("SELECT t FROM Ticket t" +
            " WHERE t.departure.id = :departureId and t.carriageNumber = :carriageNumber and t.seatNumber = :seatNumber" +
            " and t.userArrivalDate > :departureDate and t.userDepartureDate < :arrivalDate")
    List<Ticket> findTicketForUser(String k);
}
