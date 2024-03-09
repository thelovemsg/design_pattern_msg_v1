package org.reservation.system.fee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.room.domain.Room;

@Entity
@Table(name = "T_ROOM_FEE")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_fee_id"))
public class RoomFee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_id")
    private Fee fee;
}
