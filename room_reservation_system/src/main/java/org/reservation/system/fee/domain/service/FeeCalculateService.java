package org.reservation.system.fee.domain.service;

import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface FeeCalculateService {
    BigDecimal calculateFee(ReservationCreationDTO reservationCreationDTO);
}
