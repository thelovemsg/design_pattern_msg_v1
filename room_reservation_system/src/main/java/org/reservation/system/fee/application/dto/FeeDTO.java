package org.reservation.system.fee.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FeeDTO {
    private Long id;
    @NotBlank
    private String feeName;
    @DecimalMin(value = "10000")
    private BigDecimal feeAmount;
    @NotBlank
    private String roomTypeCd;
    private String remark;

}
