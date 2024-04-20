package org.reservation.system.fee.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyRoomFeeDTO {

    private String feeName;
    private LocalDate occurDate;
    private String currentCode;
    private LocalTime closeTime;
    private BigDecimal addedAmount;
    private BigDecimal productAmount;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private List<PricingHistoryDTO> pricingHistoryDTOList;

}
