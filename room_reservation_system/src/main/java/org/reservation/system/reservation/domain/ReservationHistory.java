package org.reservation.system.reservation.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.ZonedDateTime;

@Entity
@Getter
@Table(name = "T_ROOM_RESERVATION_HISTORY")
@AttributeOverride(name = "id", column = @Column(name = "rsvr_his_id"))
public class ReservationHistory extends BaseEntity {

    private ZonedDateTime enterDate;
    private ZonedDateTime leaveDate;

}
