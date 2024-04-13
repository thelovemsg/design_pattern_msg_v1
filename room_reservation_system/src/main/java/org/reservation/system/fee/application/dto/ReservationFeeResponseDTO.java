package org.reservation.system.fee.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationFeeResponseDTO {
    private BigDecimal productAmount;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
}
