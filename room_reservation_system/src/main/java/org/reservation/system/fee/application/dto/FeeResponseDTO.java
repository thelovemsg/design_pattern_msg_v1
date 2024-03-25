package org.reservation.system.fee.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class FeeResponseDTO {
    private Long id;
    private String feeName;
    private String roomTypeCd;
    private BigDecimal feeAmount;
    private String remark;

}
