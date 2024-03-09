package org.reservation.system.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

@Entity
@Getter
@Table(name = "T_ROOM_RSV_HST")
@AttributeOverride(name = "id", column = @Column(name = "rsvr_his_id"))
public class ReservationHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;

}
