package org.reservation.system.room.infrastructure.repository;

import org.reservation.system.room.domain.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    RoomType findByRoomType(String roomType);
}
