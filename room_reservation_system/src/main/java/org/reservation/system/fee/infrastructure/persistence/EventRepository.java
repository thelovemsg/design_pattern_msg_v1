package org.reservation.system.fee.infrastructure.persistence;

import org.reservation.system.fee.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE :date BETWEEN e.startDate AND e.endDate AND e.deleted = FALSE")
    List<Event> findByDateBetween(@Param("date") LocalDate date);
}
