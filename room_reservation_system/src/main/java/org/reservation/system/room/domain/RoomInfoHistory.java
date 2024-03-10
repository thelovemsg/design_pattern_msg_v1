package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "T_ROOM_INFO_HIS")
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
