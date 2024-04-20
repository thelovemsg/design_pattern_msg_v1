package org.reservation.system.fee.infrastructure.persistence;

import org.reservation.system.fee.domain.model.TempDailyFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TempDailyFeeRepository extends JpaRepository<TempDailyFee, Long> {
    @Query("SELECT x FROM TempDailyFee x WHERE x.occurDate >= :startDate AND x.occurDate < :endDate")
    Optional<List<TempDailyFee>> findByOccurDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
