package org.reservation.system.fee.infrastructure.repository;

import org.reservation.system.fee.domain.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee, Long> {
}
