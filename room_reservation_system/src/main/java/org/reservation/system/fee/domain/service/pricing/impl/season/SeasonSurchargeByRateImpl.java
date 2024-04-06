package org.reservation.system.fee.domain.service.pricing.impl.season;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.domain.service.pricing.SurchargingStrategy;
import org.reservation.system.fee.value.MoneyInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SeasonSurchargeByRateImpl implements SurchargingStrategy {
    @Override
    public PriceVO surchargeFee(MoneyInfo moneyInfo) {
        moneyInfo = moneyInfo.calculateAmountByPercent("1.2");
        return PriceVO.builder()
                .surchargedPrice(moneyInfo.getDifferentAmount())
                .finalApplyPrice(moneyInfo.getSalesAmount())
                .build();
    }
}
