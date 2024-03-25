package org.reservation.system.room.domain.repository;

import org.reservation.system.room.domain.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNo(final Integer roomNo);
    Page<Room> findAll(Pageable pageable);
}
