package org.reservation.system.calander.infrastructure;

import org.reservation.system.calander.domain.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CalenderRepository extends JpaRepository<Calender, Long> {
    List<Calender> findBySolarDateBetween(LocalDate startDate, LocalDate endDate);
    List<Calender> findBySolarDateGreaterThanEqualAndSolarDateLessThan(LocalDate startDate, LocalDate endDate);
}
