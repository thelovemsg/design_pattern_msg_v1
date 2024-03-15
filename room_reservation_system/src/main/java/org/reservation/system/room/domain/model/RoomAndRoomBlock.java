package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

@Entity
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_room_blck_id"))
public class RoomAndRoomBlock extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "room_blck_id")
    private RoomBlock roomBlock;
}
