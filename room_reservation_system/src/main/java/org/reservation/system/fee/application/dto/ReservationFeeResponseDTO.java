package org.reservation.system.fee.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationFeeResponseDTO {
    private BigDecimal productAmount;
    private BigDecimal discountAmount;
    private BigDecimal addedAmount;
    private BigDecimal salesAmount;
    private List<PricingHistoryDTO> pricingHistoryDTOList = new ArrayList<>();
}
