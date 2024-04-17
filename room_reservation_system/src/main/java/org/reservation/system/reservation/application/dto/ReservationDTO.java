package org.reservation.system.reservation.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ReservationDTO {
    private Long id;
    @NotNull
    private Integer roomNo;
    private Integer custNo;
    private Integer custNm;
    @NotEmpty
    private String feeName;
    @NotEmpty
    private String roomTypeCd;
    private String reservationMethod;
    @NotEmpty
    private String guestName;
    @NotEmpty
    private String guestTelno;
    private String stayStatus;
    @NotNull
    private Integer stayDayCnt;
    @NotEmpty
    private String reserverName;
    @NotEmpty
    private String reserverTelno;
    @NotEmpty
    private String enterRoomDate;
    @NotEmpty
    private String leaveRoomDate;
    private BigDecimal discountAmount;
    @NotNull
    private BigDecimal salesAmount;
    @NotNull
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private String vipDivCd;
    private String couponCode;

    public static ReservationDTO reservationToDTO(Reservation reservation) {
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
