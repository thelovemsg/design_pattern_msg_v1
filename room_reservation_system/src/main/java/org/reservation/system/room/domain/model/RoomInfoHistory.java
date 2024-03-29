package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "T_ROOM_INFO_HIS", indexes = {
        @Index(name = "idx_room_his_id", columnList = "room_his_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_his_id"))
public class RoomInfoHistory extends BaseEntity {

    private String roomStatus;
    private String reason;
    @Column(length = 300)
    private String remark;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

}
