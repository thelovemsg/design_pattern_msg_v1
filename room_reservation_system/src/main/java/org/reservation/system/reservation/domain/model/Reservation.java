package org.reservation.system.reservation.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
import org.reservation.system.fee.domain.model.DailyRoomFee;
import org.reservation.system.message.domain.Message;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.domain.model.other.RoomReservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;
import org.reservation.system.stay.domain.Stay;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "T_RSV", indexes = {
        @Index(name = "idx_rsvr_id", columnList = "rsvr_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "rsvr_id"))
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation extends BaseEntity {

    @Embedded
    private ReservationInfo reservationInfo;

    private String reservationMethod;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    private List<ReservationHistory> reservationHistoryList;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    private List<Message> messageList;

    @OneToMany(mappedBy = "reservation")
    private List<RoomReservation> roomReservationList;

    @OneToMany(mappedBy = "reservation")
    private List<DailyRoomFee> dailyRoomFeeList;

    @OneToOne(mappedBy = "reservation", orphanRemoval = true)
    private Stay stay;

    public static ReservationDTO entityToDTO(Reservation reservation, List<DailyRoomFeeDTO> dailyRoomFeeDTOList) {
        ReservationInfo reservationInfo = reservation.getReservationInfo();
        return ReservationDTO.builder()
                .id(reservation.getId())
                .roomNo(reservationInfo.getRoomNo())
                .reserverName(reservationInfo.getReserverName())
                .reserverTelno(reservationInfo.getReserverTelno())
                .reservationMethod(reservation.getReservationMethod())
                .stayDayCnt(reservationInfo.getStayDayCnt())
                .enterRoomDate(reservationInfo.getEnterRoomDate())
                .leaveRoomDate(reservationInfo.getLeaveRoomDate())
                .productAmount(reservationInfo.getProductAmount())
                .discountAmount(reservationInfo.getDiscountAmount())
                .salesAmount(reservationInfo.getSalesAmount())
                .vipDivCd(reservationInfo.getVipDivCd())
                .couponCode(reservationInfo.getCouponCode())
                .dailyRoomFeeDToList(dailyRoomFeeDTOList)
                .build();
    }
}
