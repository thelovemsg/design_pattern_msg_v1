package org.reservation.system.fee.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class FeeResponseDTO {
    private Long id;
    private String feeName;
    private BigDecimal feeAmount;
    private String remark;

}
