package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.ZonedDateTime;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "T_ROOM_BLOCK")
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
