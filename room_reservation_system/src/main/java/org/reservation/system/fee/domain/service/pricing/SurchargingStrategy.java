package org.reservation.system.fee.domain.service.pricing;

import org.reservation.system.fee.application.vo.PriceVO;
import org.reservation.system.fee.value.MoneyInfo;

public interface SurchargingStrategy {
    PriceVO surchargeFee(MoneyInfo moneyInfo);
}
