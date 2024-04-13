package org.reservation.system.fee.application.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceVO {

    @Builder.Default
    BigDecimal originPrice = new BigDecimal("0");
    @Builder.Default
    BigDecimal discountPrice = new BigDecimal("0");
    @Builder.Default
    BigDecimal finalApplyPrice = new BigDecimal("0");
    @Builder.Default
    BigDecimal surchargedPrice = new BigDecimal("0");
}
