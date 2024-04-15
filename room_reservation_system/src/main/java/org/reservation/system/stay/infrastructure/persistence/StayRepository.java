package org.reservation.system.stay.infrastructure.persistence;

import org.reservation.system.stay.domain.Stay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<Stay, Long> {
}
