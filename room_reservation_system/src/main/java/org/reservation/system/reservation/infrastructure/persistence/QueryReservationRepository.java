package org.reservation.system.reservation.infrastructure.persistence;

import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryReservationRepository {
    List<Reservation> findReservationWithComplexConditions(Pageable pageable, ReservationSearchDTO reservationSearchDTO);
    long countReservationWithComplexConditions(ReservationSearchDTO reservationSearchDTO);
}
