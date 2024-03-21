package org.reservation.system.room.infrastructure.repository;

import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.domain.model.Room;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryRoomRepository {
    List<Room> findWithComplexConditions(Pageable pageable, RoomSearchDTO roomSearchDTO);
    long countWithComplexConditions(RoomSearchDTO roomSearchDTO);
}
