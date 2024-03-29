package org.reservation.system.room.domain.repository;

import org.reservation.system.room.domain.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNoAndDeletedIsFalse(final Integer roomNo);
    Optional<Room> findByRoomNameAndDeletedIsFalse(final String roomName);
    Optional<Room> findByIdAndDeletedIsFalse(final Long id);
    Page<Room> findByDeletedIsFalse(Pageable pageable);

}
