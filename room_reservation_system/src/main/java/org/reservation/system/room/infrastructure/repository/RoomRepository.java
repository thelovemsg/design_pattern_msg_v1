package org.reservation.system.room.infrastructure.repository;

import org.reservation.system.room.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNo(final Integer roomNo);
}
