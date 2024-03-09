package org.reservation.system.room.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.fee.domain.Fee;
import org.reservation.system.fee.domain.RoomFee;
import org.reservation.system.reservation.domain.other.RoomReservation;
import org.reservation.system.stay.domain.other.RoomStay;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "T_ROOM")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "room_id"))
public class Room extends BaseEntity {

    private Integer roomNo;
    private String roomName;
    private String roomType;
    private String unit;
    private BigDecimal measure;
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
