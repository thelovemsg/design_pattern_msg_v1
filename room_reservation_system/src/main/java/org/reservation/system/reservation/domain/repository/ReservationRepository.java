package org.reservation.system.reservation.domain.repository;

import org.reservation.system.reservation.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
