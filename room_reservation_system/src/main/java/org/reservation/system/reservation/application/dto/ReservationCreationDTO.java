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
public class ReservationCreationDTO {
    private String guestName;
    private String guestTelno;
    private String stayStatus;
    private Integer stayDayCnt;
    private String reserverName;
    private String reserverTelno;
    private LocalDate enterRoomDate;
    private LocalDate leaveRoomDate;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private String reservationMethod;
    private String vipDivCd;
    private String couponCode;
}
