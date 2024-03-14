package org.reservation.system.fee.domain.service.impl;

import org.reservation.system.fee.domain.service.FeeCalculateService;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BasicFeeCalculateImpl implements FeeCalculateService {
    @Override
    public BigDecimal calculateFee(ReservationCreationDTO reservationCreationDTO) {
        return null;
    }
}

