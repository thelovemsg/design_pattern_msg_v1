package org.reservation.system.reservation.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.model.DailyRoomFee;
import org.reservation.system.message.domain.Message;
import org.reservation.system.reservation.domain.model.other.RoomReservation;
import org.reservation.system.reservation.value.ReservationInfo;
import org.reservation.system.stay.domain.Stay;

import java.util.List;

@Entity
@Table(name = "T_RSV", indexes = {
        @Index(name = "idx_rsvr_id", columnList = "rsvr_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "rsvr_id"))
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

}
