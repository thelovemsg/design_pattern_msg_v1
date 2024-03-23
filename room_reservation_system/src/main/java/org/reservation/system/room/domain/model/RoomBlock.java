package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "T_ROOM_BLOCK", indexes = {
        @Index(name = "idx_room_blck_id", columnList = "room_blck_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_blck_id"))
public class RoomBlock extends BaseEntity {

    private String roomBlockType;
    private ZonedDateTime blockStartDate;
    private ZonedDateTime blockEndDate;
    private ZonedDateTime blockEndPlanDate;
    private String remark;

    @OneToMany(mappedBy = "roomBlock")
    private List<RoomAndRoomBlock> roomAndRoomBlock;
}
