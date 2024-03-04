package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.room.enums.RoomStatusEnum;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "T_ROOM_INFO_HIS")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_his_id"))
public class RoomInfoHistory extends BaseEntity {

    @Enumerated(STRING)
    private RoomStatusEnum roomStatus;
    private String reason;
    @Column(length = 300)
    private String remark;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

}
