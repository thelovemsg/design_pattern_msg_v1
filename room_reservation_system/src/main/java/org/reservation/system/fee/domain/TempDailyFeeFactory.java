package org.reservation.system.fee.domain;

import lombok.RequiredArgsConstructor;
import org.reservation.system.calander.domain.Calender;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.fee.domain.model.TempDailyFee;
import org.reservation.system.fee.infrastructure.persistence.TempDailyFeeRepository;
import org.reservation.system.fee.value.Money;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class TempDailyFeeFactory {

    private final TempDailyFeeRepository tempDailyFeeRepository;

    public TempDailyFee create(Fee fee, Calender calender) {
        TempDailyFee tempDailyFee = TempDailyFee.builder()
                .feeName(fee.getFeeName())
                .roomTypeCd(fee.getRoomType().getRoomTypeCd())
                .occurDate(calender.getSolarDate())
                .money(Money.builder()
                        .productAmount(fee.getFeeAmount())
                        .taxAmount(fee.getFeeAmount().multiply(new BigDecimal("0.1")))
                        .salesAmount(fee.getFeeAmount())
                        .build())
                .occurTime(LocalTime.now())
                .build();

        tempDailyFeeRepository.save(tempDailyFee);

        return tempDailyFee;
    }

}
