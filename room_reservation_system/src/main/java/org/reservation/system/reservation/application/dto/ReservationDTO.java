package org.reservation.system.reservation.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {
    private Long id;
    private Integer roomNo;
    private String reservationMethod;
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
    private String vipDivCd;
    private String couponCode;

    public static ReservationDTO ReservationToDTO(Reservation reservation) {
//        ReservationInfo reservationInfo = reservation.getReservationInfo();
//        return ReservationDTO.builder()
//                .id(reservation.getId())
//                .roomNo(reservationInfo.getRoomNo())
//                .reserverName(reservationInfo.getReserverName())
//                .reserverTelno(reservationInfo.getReserverTelno())
//                .reservationMethod(reservation.getReservationMethod())
//                .stayDayCnt(reservationInfo.getStayDayCnt())
//                .enterRoomDate(reservationInfo.getEnterRoomDate())
//                .leaveRoomDate(reservationInfo.getLeaveRoomDate())
//                .productAmount(reservationInfo.getProductAmount())
//                .discountAmount(reservationInfo.getDiscountAmount())
//                .salesAmount(reservationInfo.getSalesAmount())
//                .vipDivCd(reservationInfo.getVipDivCd())
//                .couponCode(reservationInfo.getCouponCode())
//                .build();
                return ReservationDTO.builder()
                .id(1L)
                .roomNo(1111)
                .guestTelno("010-5844-7785")
                .reserverName("123123")
                .reserverTelno("010-5844-7785")
                .reservationMethod("알아서 잘")
                .stayDayCnt(5)
                .enterRoomDate(LocalDate.now())
                .leaveRoomDate(LocalDate.now())
                .productAmount(new BigDecimal("100000"))
                .discountAmount(new BigDecimal("10000"))
                .salesAmount(new BigDecimal("90000"))
                .vipDivCd("test")
                .couponCode("code")
                .build();
    }
}
