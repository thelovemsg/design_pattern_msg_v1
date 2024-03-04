package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.util.List;

@Entity
@Table(name = "T_ROOM")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_id"))
public class Room extends BaseEntity {

    private Integer roomNo;
    private String roomName;
    private String roomType;
    @Column(length = 300)
    private String remark;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<RoomBlock> roomBlockList;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<RoomInfoHistory> roomInfoHistoryList;

}
