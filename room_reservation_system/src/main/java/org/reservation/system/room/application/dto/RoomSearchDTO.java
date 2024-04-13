package org.reservation.system.room.application.dto;

import lombok.*;

import java.time.LocalDate;

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
    private LocalDate startDate;
    private LocalDate endDate;
}
