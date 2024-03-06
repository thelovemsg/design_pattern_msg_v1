package org.reservation.system.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.message.domain.Message;
import org.reservation.system.reservation.enums.FeeApplyCdEnum;
import org.reservation.system.reservation.enums.ReservationMethodEnum;
import org.reservation.system.reservation.value.GuestInfo;
import org.reservation.system.reservation.value.ReserverInfo;
import org.reservation.system.stay.enums.StayStusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "T_ROOM_RESERVATION")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "rsvr_id"))
public class Reservation extends BaseEntity {

    private String guestName;
    private String guestTelno;
    private StayStusEnum stayStatus;
    private Integer stayDayCnt;
    private String reserverName;
    private String reserverTelno;
    private LocalDate enterRoomDate;
    private LocalDate leaveRoomDate;
    private BigDecimal discountAmount;
    private BigDecimal salesAmount;
    private BigDecimal productAmount;
    private BigDecimal taxAmount;
    private FeeApplyCdEnum feeApplyCd;

    @Enumerated(STRING)
    private ReservationMethodEnum reservationMethod;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    private List<ReservationHistory> reservationHistoryList;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    private List<Message> messageList;

}
