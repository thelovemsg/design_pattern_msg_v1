package org.reservation.system.room.domain.repository;

import org.reservation.system.room.domain.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    Optional<RoomType> findByRoomTypeCdAndDeletedIsFalse(String roomTypeCd);

}
