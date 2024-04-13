package org.reservation.system.reservation.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationSearchDTO {
    private String guestName;
    private String guestTelno;
    private LocalDate enterRoomDate;
    private LocalDate leaveRoomDate;
    private BigDecimal minSalesAmount;
    private BigDecimal maxSalesAmount;
    private String vipDivCd;
    private String couponCode;
}
