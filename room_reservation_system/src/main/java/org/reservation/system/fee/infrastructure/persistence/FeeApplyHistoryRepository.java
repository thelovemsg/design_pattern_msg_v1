package org.reservation.system.fee.infrastructure.persistence;

import org.reservation.system.fee.domain.model.PricingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingHistoryRepository extends JpaRepository<PricingHistory, Long> {
}
