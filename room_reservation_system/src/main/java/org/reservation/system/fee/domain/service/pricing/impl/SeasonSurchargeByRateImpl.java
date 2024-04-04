package org.reservation.system.fee.domain.service.pricing.impl;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;

import java.math.BigDecimal;

public class SeasonSurchargeByRateImpl implements SurchargingStrategy {

    @Override
    public PriceVO surchargeFee(BigDecimal originalPrice) {
        //TODO : 요금을 어떻게 합칠건지 생각해본다.

        BigDecimal addedPrice = new BigDecimal("10000");
        return PriceVO.builder()
                .surchargedPrice(addedPrice)
                .finalApplyPrice(originalPrice.add(addedPrice))
                .build();
    }
}
