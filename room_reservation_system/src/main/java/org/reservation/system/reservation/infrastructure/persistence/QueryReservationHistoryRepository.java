package org.reservation.system.reservation.infrastructure.persistence;

import org.reservation.system.reservation.application.dto.ReservationHistorySearchDTO;
import org.reservation.system.reservation.domain.model.ReservationHistory;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryReservationHistoryRepository {
    List<ReservationHistory> findWithComplexConditions(Pageable pageable, ReservationHistorySearchDTO reservationHistorySearchDTO);
}
