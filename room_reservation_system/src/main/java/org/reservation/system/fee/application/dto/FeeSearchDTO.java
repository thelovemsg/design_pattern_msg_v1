package org.reservation.system.fee.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FeeSearchDTO {
    private String feeName;
    private BigDecimal minFeeAmount;
    private BigDecimal maxFeeAmount;
    private String roomTypeCd;

}
