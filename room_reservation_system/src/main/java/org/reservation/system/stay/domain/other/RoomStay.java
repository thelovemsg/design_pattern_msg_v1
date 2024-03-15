package org.reservation.system.stay.domain.other;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.stay.domain.Stay;

@Entity
@Getter
@Table(name = "T_ROOM_STAY")
@AttributeOverride(name = "id", column = @Column(name = "room_stay_id"))
public class RoomStay extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stay_id")
    private Stay stay;

}
