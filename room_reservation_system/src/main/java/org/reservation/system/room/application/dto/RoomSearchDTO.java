package org.reservation.system.room.application.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomSearchDTO {
    private String roomTypeCd;
    private String roomName;
    private Integer roomNo;
    private String remark;
}
