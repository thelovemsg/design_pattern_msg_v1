package org.reservation.system.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.reservation.value.GuestInfo;
import org.reservation.system.reservation.value.ReserverInfo;

import java.time.ZonedDateTime;

@Entity
@Table(name = "T_ROOM_RESERVATION")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_rsvr_id"))
public class Reservation extends BaseEntity {

    private ZonedDateTime enterDate;
    private ZonedDateTime leaveDate;
    @Embedded
    private GuestInfo guestInfo;
    @Embedded
    private ReserverInfo reserverInfo;

    private Integer stayDayCnt;





}
