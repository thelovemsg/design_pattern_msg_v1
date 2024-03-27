package org.reservation.system.reservation.infrastructure.persistence.impl;

import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryReservationRepositoryImpl implements QueryReservationRepository {
    @Override
    public List<Reservation> findReservationWithComplexConditions(Pageable pageable, ReservationSearchDTO reservationSearchDTO) {
        return null;
    }

    @Override
    public long countReservationWithComplexConditions(ReservationSearchDTO reservationSearchDTO) {
        return 0;
    }
}
