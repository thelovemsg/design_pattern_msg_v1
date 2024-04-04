package org.reservation.system.fee.domain.service.pricing.impl;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;

import java.math.BigDecimal;

public class SeasonSurchargeByFixedAmountImpl implements SurchargingStrategy {
    @Override
    public PriceVO surchargeFee(BigDecimal originalPrice) {
        return null;
    }
}
