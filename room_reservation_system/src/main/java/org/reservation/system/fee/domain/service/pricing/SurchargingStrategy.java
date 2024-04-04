package org.reservation.system.fee.domain.service.pricing;

import org.reservation.system.fee.application.vo.PriceVO;

import java.math.BigDecimal;

public interface SurchargingStrategy {
    PriceVO surchargeFee(BigDecimal originalPrice);

}
