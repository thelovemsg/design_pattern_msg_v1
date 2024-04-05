package org.reservation.system.fee.domain.service.pricing.impl.peak;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.value.MoneyInfo;

import java.math.BigDecimal;

public class PeakSurchargeByRateImpl implements SurchargingStrategy {
    @Override
    public PriceVO surchargeFee(MoneyInfo moneyInfo) {
        BigDecimal newAddedAmount = moneyInfo.calculateAmountByPercent("1.2");
        return PriceVO.builder()
                .surchargedPrice(newAddedAmount)
                .finalApplyPrice(moneyInfo.getSalesAmount())
                .build();
    }
}
