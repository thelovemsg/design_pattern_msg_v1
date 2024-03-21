package org.reservation.system.room.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomSearchDTO {
    private String roomType;
    private String roomName;
    private Integer roomNo;
    private String remark;
}
