package org.reservation.system.room.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.reservation.domain.model.other.RoomReservation;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.stay.domain.other.RoomStay;

import java.util.List;

@Entity
@Table(name = "T_ROOM", indexes = {
        @Index(name = "idx_room_id", columnList = "room_id")
})
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_id"))
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {

    @Column(unique=true)
    private Integer roomNo;
    @Column(unique=true)
    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @Column(length = 300)
    private String remark;

    @OneToMany(mappedBy = "room")
    private List<RoomInfoHistory> roomInfoHistoryList;

    @OneToMany(mappedBy = "room")
    private List<RoomReservation> roomReservationList;

    @OneToMany(mappedBy = "room")
    private List<RoomAndRoomBlock> roomAndRoomBlockList;

    @OneToMany(mappedBy = "room")
    private List<RoomStay> roomStayList;

    public void changeRoomInfo(RoomDTO roomDTO, RoomType findRoomType) {
        roomName = roomDTO.getRoomName();
        roomNo = roomDTO.getRoomNo();
        remark = roomDTO.getRemark();
        if(!getRoomType().equals(findRoomType)) {
            roomType = findRoomType;
        }
    }
}
