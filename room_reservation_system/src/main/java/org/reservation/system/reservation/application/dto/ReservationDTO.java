package org.reservation.system.reservation.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;
import org.springframework.format.datetime.DateFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {
    private Long id;
    private Integer roomNo;
    private Integer custNo;
    private Integer custNm;
    private String feeName;
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

    public static ReservationDTO ReservationToDTO(Reservation reservation) {
        ReservationInfo reservationInfo = reservation.getReservationInfo();
        return ReservationDTO.builder()
                .id(reservation.getId())
                .roomNo(reservationInfo.getRoomNo())
                .reserverName(reservationInfo.getReserverName())
                .reserverTelno(reservationInfo.getReserverTelno())
                .reservationMethod(reservation.getReservationMethod())
                .stayDayCnt(reservationInfo.getStayDayCnt())
                .enterRoomDate(reservationInfo.getEnterRoomDate().format(DateTimeFormatter.ISO_DATE))
                .leaveRoomDate(reservationInfo.getLeaveRoomDate().format(DateTimeFormatter.ISO_DATE))
                .productAmount(reservationInfo.getProductAmount())
                .discountAmount(reservationInfo.getDiscountAmount())
                .salesAmount(reservationInfo.getSalesAmount())
                .vipDivCd(reservationInfo.getVipDivCd())
                .couponCode(reservationInfo.getCouponCode())
                .build();
    }
}
