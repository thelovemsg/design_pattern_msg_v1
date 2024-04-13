package org.reservation.system.fee.infrastructure.persistence;

import org.reservation.system.fee.domain.model.TempDailyFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempDailyFeeRepository extends JpaRepository<TempDailyFee, Long> {
}
