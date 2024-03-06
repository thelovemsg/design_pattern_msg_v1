package org.reservation.system.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.stay.enums.StayStusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Getter
@Table(name = "T_ROOM_RESERVATION_HISTORY")
@AttributeOverride(name = "id", column = @Column(name = "rsvr_his_id"))
public class ReservationHistory extends BaseEntity {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;

}
