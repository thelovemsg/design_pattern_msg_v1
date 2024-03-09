package org.reservation.system.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.message.domain.Message;
import org.reservation.system.reservation.domain.other.RoomReservation;
import org.reservation.system.reservation.enums.FeeApplyCdEnum;
import org.reservation.system.reservation.enums.ReservationMethodEnum;
import org.reservation.system.reservation.value.ReservationInfo;
import org.reservation.system.stay.enums.StayStusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "T_ROOM_RESERVATION")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "rsvr_id"))
public class Reservation extends BaseEntity {

    @Embedded
    private ReservationInfo reservationInfo;

    @Enumerated(STRING)
    private ReservationMethodEnum reservationMethod;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    private List<ReservationHistory> reservationHistoryList;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    private List<Message> messageList;

    @OneToMany(mappedBy = "reservation")
    private List<RoomReservation> roomReservationList;

}
