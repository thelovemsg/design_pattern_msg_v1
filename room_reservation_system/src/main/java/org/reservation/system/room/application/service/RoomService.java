package org.reservation.system.room.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomCreationDTO;
import org.reservation.system.room.application.dto.RoomResponse;
import org.reservation.system.room.domain.Room;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public RoomResponse createRoom(RoomCreationDTO dto) {
        final Room byRoomNo = roomRepository.findByRoomNo(dto.getRoomNo());
        if(byRoomNo != null) {
            throw new IllegalArgumentException("ROOM_ALREADY_EXIST!!!");
        }

        Room newRoom = Room.builder().roomNo(dto.getRoomNo()).roomName(dto.getRoomName()).roomType(dto.getRoomType()).remark(dto.getRemark()).build();
        Room savedRoom = roomRepository.save(newRoom);

        return RoomResponse.builder()
                .id(savedRoom.getId())
                .roomType(savedRoom.getRoomType())
                .roomName(savedRoom.getRoomName())
                .roomNo(savedRoom.getRoomNo())
                .remark(savedRoom.getRemark())
                .build();
    }
}
