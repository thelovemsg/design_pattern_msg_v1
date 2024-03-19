package org.reservation.system.room.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class RoomResponseDTO {

    private final Long id;
    private final Integer roomNo;
    private final String roomType;
    private final String roomName;
    private final String remark;
}
