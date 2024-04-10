package org.reservation.system.room.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.domain.model.Room;

@Getter
@Builder
@RequiredArgsConstructor
public class RoomResponseDTO {

    private final Long id;
    private final Integer roomNo;
    private final String roomTypeCd;
    private final String roomName;
    private final String remark;

    public static RoomResponseDTO convertRoomToDTO(Room room) {
        return RoomResponseDTO.builder()
                .roomNo(room.getRoomNo())
                .roomName(room.getRoomName())
                .roomTypeCd(room.getRoomType().getRoomTypeCd())
                .remark(room.getRemark())
                .build();
    }
}
