package org.reservation.system.fee.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FeeDTO {
    private Long id;
    @NotBlank
    private String feeName;
    private BigDecimal feeAmount;
    @NotBlank
    private String roomTypeCd;
    private String remark;

}
