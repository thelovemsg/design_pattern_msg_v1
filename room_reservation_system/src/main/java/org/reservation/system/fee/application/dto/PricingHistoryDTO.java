package org.reservation.system.fee.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
public class PricingHistoryDTO {
    private String applyReason;
    private String pricingType;
    private BigDecimal appliedPrice;
}
