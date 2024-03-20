package org.reservation.system.room.application.service;

import org.reservation.system.room.application.dto.RoomTypeResponseDTO;

import java.util.List;

public interface RoomTypeService {
    List<RoomTypeResponseDTO> selectAllRoomType();
}
