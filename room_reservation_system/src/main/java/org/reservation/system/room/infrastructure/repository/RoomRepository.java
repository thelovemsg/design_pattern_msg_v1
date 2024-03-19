package org.reservation.system.room.infrastructure.repository;

import org.reservation.system.room.domain.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNo(final Integer roomNo);
    List<Room> findAll();
    Page<Room> findAll(Pageable pageable);
}
