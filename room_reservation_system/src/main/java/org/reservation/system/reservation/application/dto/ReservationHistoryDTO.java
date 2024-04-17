package org.reservation.system.reservation.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationHistoryDTO {
    private Long id;
    private Integer roomNo;
    private String roomTypeCd;
    private String reservationMethod;
    private String guestName;
    private String guestTelno;
    private String stayStatus;
    private Integer stayDayCnt;
    private String reserverName;
    private String reserverTelno;
    private String enterRoomDate;
    private String leaveRoomDate;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private String vipDivCd;
    private String couponCode;
}
