package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.room.enums.RoomStatusEnum;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "T_ROOM_INFO_HIS")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class RoomInfoHistory extends BaseEntity {

    @Enumerated(STRING)
    private RoomStatusEnum roomStatusEnum;
    private String reason;
    @Column(length = 300)
    private String remark;

}
