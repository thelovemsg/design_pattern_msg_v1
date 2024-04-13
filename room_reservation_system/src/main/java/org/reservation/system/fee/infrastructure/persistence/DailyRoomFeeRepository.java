package org.reservation.system.fee.infrastructure.persistence;

import org.reservation.system.fee.domain.model.DailyRoomFee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRoomFeeRepository extends JpaRepository<DailyRoomFee, Long> {
}
