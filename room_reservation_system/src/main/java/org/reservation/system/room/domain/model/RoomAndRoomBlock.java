package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

@Entity
@Getter
@Table(name = "T_ROOM_AND_ROOM_BLCK", indexes = {
        @Index(name = "idx_room_room_blck_id", columnList = "room_room_blck_id")
})
@AttributeOverride(name = "id", column = @Column(name = "room_room_blck_id"))
public class RoomAndRoomBlock extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "room_blck_id")
    private RoomBlock roomBlock;
}
