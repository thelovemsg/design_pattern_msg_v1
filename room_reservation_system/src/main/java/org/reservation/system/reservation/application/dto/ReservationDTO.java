package org.reservation.system.reservation.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ReservationDTO implements Serializable {

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate enterRoomDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate leaveRoomDate;
    private BigDecimal discountAmount;
    @NotNull
    private BigDecimal salesAmount;
    @NotNull
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private String vipDivCd;
    private String couponCode;
    private List<DailyRoomFeeDTO> dailyRoomFeeDToList;

    public static Reservation dtoToEntity(ReservationDTO reservationDTO) {
        return Reservation
                .builder()
                .reservationMethod(reservationDTO.getReservationMethod())
                .reservationInfo(ReservationInfo
                        .builder()
                        .couponCode(reservationDTO.getCouponCode())
                        .vipDivCd(reservationDTO.getVipDivCd())
                        .guestName(reservationDTO.getGuestName())
                        .guestTelno(reservationDTO.getGuestTelno())
                        .stayStatus(reservationDTO.getStayStatus())
                        .roomNo(reservationDTO.getRoomNo())
                        .stayDayCnt(reservationDTO.getStayDayCnt())
                        .reserverName(reservationDTO.getReserverName())
                        .reserverTelno(reservationDTO.getReserverTelno())
                        .enterRoomDate(reservationDTO.getEnterRoomDate())
                        .leaveRoomDate(reservationDTO.getLeaveRoomDate())
                        .discountAmount(reservationDTO.getDiscountAmount())
                        .salesAmount(reservationDTO.getSalesAmount())
                        .productAmount(reservationDTO.getProductAmount())
                        .taxAmount(reservationDTO.getTaxAmount())
                        .vipDivCd(reservationDTO.getVipDivCd())
                        .couponCode(reservationDTO.getCouponCode())
                        .build())
                .build();

    }

}
