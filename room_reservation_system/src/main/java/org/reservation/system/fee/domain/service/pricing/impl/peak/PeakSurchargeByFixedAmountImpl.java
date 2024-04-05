package org.reservation.system.fee.domain.service.pricing.impl.peak;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.value.MoneyInfo;

import java.math.BigDecimal;

public class PeakSurchargeByFixedAmountImpl implements SurchargingStrategy {
    @Override
    public PriceVO surchargeFee(MoneyInfo moneyInfo) {
        BigDecimal addedPrice = new BigDecimal("20000");
        moneyInfo.addAmount(addedPrice);
        return PriceVO.builder()
                .surchargedPrice(addedPrice)
                .finalApplyPrice(moneyInfo.getSalesAmount())
                .build();
    }
}
