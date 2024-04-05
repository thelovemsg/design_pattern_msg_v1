package org.reservation.system.fee.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PricingHistoryDTO {
    private String applyReason;
    private String pricingType;
    private BigDecimal appliedPrice;
}
