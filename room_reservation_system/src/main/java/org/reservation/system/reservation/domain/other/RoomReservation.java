package org.reservation.system.reservation.domain.other;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.room.domain.model.Room;

@Entity
@Getter
@Table(name = "T_ROOM_RSV")
@AttributeOverride(name = "id", column = @Column(name = "room_rsvr_id"))
public class RoomReservation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;


}
