package org.reservation.system.room.infrastructure.repository;

import org.reservation.system.room.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNo(final Integer roomNo);
}
