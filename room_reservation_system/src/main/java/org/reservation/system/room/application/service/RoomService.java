package org.reservation.system.room.application.service;

import org.reservation.system.room.application.dto.RoomCreationDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomService {
    RoomResponseDTO createRoom(RoomCreationDTO dto);
    Page<RoomResponseDTO> selectRoomList(Pageable pageable, RoomSearchDTO roomSearchDTO);
}
