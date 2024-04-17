package org.reservation.system.room.application.service;

import org.reservation.system.reservation.application.vo.RoomReservationQuery;
import org.reservation.system.room.application.dto.RoomCurrentStatusDTO;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {
    RoomResponseDTO createRoom(RoomDTO dto);
    Page<RoomResponseDTO> selectRoomList(Pageable pageable, RoomSearchDTO roomSearchDTO);
    RoomDTO selectRoomById(Long id);
    void deleteRoom(Long id);
    RoomResponseDTO updateRoom(RoomDTO roomDTO);
    List<RoomResponseDTO> selectRoomList(RoomSearchDTO roomSearchDTO);
    void findIsRoomReservationPossible(RoomReservationQuery roomReservationQuery);
    RoomDTO findRoomIdByRoomNo(Integer roomNo);
    List<RoomCurrentStatusDTO> selectRoomCurrentStatusByType(RoomSearchDTO roomSearchDTO);

}
