package org.reservation.system.room.application.service;

import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomResponse;
import org.reservation.system.room.domain.Room;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomResponse createRoom(final Integer roomNo, final String roomName, final String roomType, final String remark) {
        final Room byRoomNo = roomRepository.findByRoomNo(roomNo);
        if(byRoomNo != null) {
            throw new IllegalArgumentException("ROOM_ALREADY_EXIST!!!");
        }

        Room newRoom = Room.builder().roomNo(roomNo).roomName(roomName).roomType(roomType).remark(remark).build();
        Room savedRoom = roomRepository.save(newRoom);

        return RoomResponse.builder()
                .id(savedRoom.getId())
                .roomType(savedRoom.getRoomType())
                .roomName(savedRoom.getRoomName())
                .remark(savedRoom.getRemark())
                .build();
    }
}
