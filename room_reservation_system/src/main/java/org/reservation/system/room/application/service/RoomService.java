package org.reservation.system.room.application.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomCreationDTO;
import org.reservation.system.room.application.dto.RoomResponse;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Transactional
    public RoomResponse createRoom(RoomCreationDTO dto) {
        RoomType roomType = roomTypeRepository.findByRoomType(dto.getRoomType());
        if(roomType == null)
            throw new EntityNotFoundException("RoomType not found");

        final Room byRoomNo = roomRepository.findByRoomNo(dto.getRoomNo());
        if(byRoomNo != null) {
            throw new IllegalArgumentException("ROOM_ALREADY_EXIST!!!");
        }

        Room newRoom = Room.builder().roomNo(dto.getRoomNo()).roomName(dto.getRoomName()).roomType(roomType).remark(dto.getRemark()).build();
        Room savedRoom = roomRepository.save(newRoom);

        return RoomResponse.builder()
                .id(savedRoom.getId())
                .roomType(savedRoom.getRoomType().getRoomTypeCd())
                .roomName(savedRoom.getRoomName())
                .roomNo(savedRoom.getRoomNo())
                .remark(savedRoom.getRemark())
                .build();
    }
}
