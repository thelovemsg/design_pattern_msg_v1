package org.reservation.system.reservation.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.model.DailyRoomFee;
import org.reservation.system.message.domain.Message;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.domain.model.other.RoomReservation;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;
import org.reservation.system.stay.domain.Stay;

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

    public static Reservation creationDtoToEntity(ReservationCreationDTO creationDTO) {
        return Reservation
                .builder()
                .reservationMethod(creationDTO.getReservationMethod())
                .reservationInfo(ReservationInfo
                                    .builder()
                                    .couponCode(creationDTO.getCouponCode())
                                    .vipDivCd(creationDTO.getVipDivCd())
                                    .guestName(creationDTO.getGuestName())
                                    .guestTelno(creationDTO.getGuestTelno())
                                    .stayStatus(creationDTO.getStayStatus())
                                    .roomNo(creationDTO.getRoomNo())
                                    .stayDayCnt(creationDTO.getStayDayCnt())
                                    .reserverName(creationDTO.getReserverName())
                                    .reserverTelno(creationDTO.getReserverTelno())
                                    .enterRoomDate(creationDTO.getEnterRoomDate())
                                    .leaveRoomDate(creationDTO.getLeaveRoomDate())
                                    .discountAmount(creationDTO.getDiscountAmount())
                                    .salesAmount(creationDTO.getSalesAmount())
                                    .productAmount(creationDTO.getProductAmount())
                                    .taxAmount(creationDTO.getTaxAmount())
                                    .vipDivCd(creationDTO.getVipDivCd())
                                    .couponCode(creationDTO.getCouponCode())
                                    .build())
                .build();

    }

}
