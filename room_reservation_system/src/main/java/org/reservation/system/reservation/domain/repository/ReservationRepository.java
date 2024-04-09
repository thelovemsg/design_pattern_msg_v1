package org.reservation.system.reservation.domain.repository;

import org.reservation.system.reservation.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);
}
