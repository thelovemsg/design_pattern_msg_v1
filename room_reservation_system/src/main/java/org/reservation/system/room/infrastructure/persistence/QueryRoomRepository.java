package org.reservation.system.room.infrastructure.persistence;

import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.domain.model.Room;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryRoomRepository {
    List<Room> findRoomWithComplexConditions(Pageable pageable, RoomSearchDTO roomSearchDTO);
    long countRoomWithComplexConditions(RoomSearchDTO roomSearchDTO);
}
