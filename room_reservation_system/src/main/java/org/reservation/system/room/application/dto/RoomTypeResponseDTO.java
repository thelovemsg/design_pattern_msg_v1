package org.reservation.system.room.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RoomTypeResponseDTO {
    Long id;
    String roomTypeName;
    String roomTypeCd;
    Long reservationCount;

    public RoomTypeResponseDTO(String roomTypeCd, Long reservationCount, Long id) {
        this.roomTypeCd = roomTypeCd;
        this.reservationCount = reservationCount;
        this.id = id;
    }
}
