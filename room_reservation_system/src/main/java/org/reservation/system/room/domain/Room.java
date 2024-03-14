package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.model.RoomFee;
import org.reservation.system.reservation.domain.other.RoomReservation;
import org.reservation.system.stay.domain.other.RoomStay;

import java.util.List;

@Entity
@Table(name = "T_ROOM")
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
    private String roomType;
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

    @OneToMany(mappedBy = "room")
    private List<RoomFee> roomFeeList;

}
