package org.reservation.system.fee.domain.service.pricing.impl.season;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.value.MoneyInfo;

import java.math.BigDecimal;

public class SeasonSurchargeByRateImpl implements SurchargingStrategy {

    @Override
    public PriceVO surchargeFee(MoneyInfo moneyInfo) {
        BigDecimal newAddedAmount = moneyInfo.addAmount(new BigDecimal("10000"));
        return PriceVO.builder()
                .surchargedPrice(newAddedAmount)
                .finalApplyPrice(moneyInfo.getSalesAmount())
                .build();
    }
}
