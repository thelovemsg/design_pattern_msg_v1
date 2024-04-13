package org.reservation.system.fee.domain.service.pricing.surcharge;

import org.reservation.system.reservation.application.dto.ReservationCreationDTO;

import java.math.BigDecimal;

public interface FeeCalculateService {
    BigDecimal calculateFee(ReservationCreationDTO reservationCreationDTO);
}
