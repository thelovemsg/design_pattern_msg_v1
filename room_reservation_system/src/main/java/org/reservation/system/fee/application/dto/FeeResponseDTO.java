package org.reservation.system.fee.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FeeResponseDTO {
    private Long id;
    private String feeName;
    private String roomTypeCd;
    private String feeAmount;
    private String remark;

}
