package org.reservation.system.reservation.domain.repository;

import org.reservation.system.reservation.domain.model.ReservationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationHistoryRepository extends JpaRepository<ReservationHistory, Long> {
}
