package org.reservation.system.fee.domain.repository;

import org.reservation.system.fee.domain.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    Optional<Fee> findByFeeName(String feeName);
}
