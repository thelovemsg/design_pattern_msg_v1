package org.reservation.system.room.infrastructure.repository;

import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;

import java.util.List;

public interface QueryRoomTypeRepository {
     List<Room> findRoomWithType(RoomType roomType);
     List<RoomType> findFeeWithType(RoomType roomType);
}
