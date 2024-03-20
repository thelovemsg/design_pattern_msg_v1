package org.reservation.system.room.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomCreationDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Override
    @Transactional
    public RoomResponseDTO createRoom(RoomCreationDTO dto) {
        RoomType roomType = roomTypeRepository.findByRoomTypeCd(dto.getRoomTypeCd());
        if(roomType == null)
            throw new EntityNotFoundException("RoomType not found");

        final Room byRoomNo = roomRepository.findByRoomNo(dto.getRoomNo());
        if(byRoomNo != null) {
            throw new IllegalArgumentException("ROOM_ALREADY_EXIST!!!");
        }

        Room newRoom = Room.builder().roomNo(dto.getRoomNo()).roomName(dto.getRoomName()).roomType(roomType).remark(dto.getRemark()).build();
        Room savedRoom = roomRepository.save(newRoom);

        return RoomResponseDTO.builder()
                .id(savedRoom.getId())
                .roomType(savedRoom.getRoomType().getRoomTypeCd())
                .roomName(savedRoom.getRoomName())
                .roomNo(savedRoom.getRoomNo())
                .remark(savedRoom.getRemark())
                .build();
    }

    @Override
    public Page<RoomResponseDTO> selectRoomList(Pageable pageable) {
        Page<Room> roomList = roomRepository.findAll(pageable);
        List<RoomResponseDTO> roomResponseList = new ArrayList<>();

        for (Room room : roomList) {
            RoomResponseDTO responseDTO = RoomResponseDTO.builder()
                    .roomNo(room.getRoomNo())
                    .roomName(room.getRoomName())
                    .roomType(room.getRoomType().getRoomTypeCd())
                    .remark(room.getRemark())
                    .build();

            roomResponseList.add(responseDTO);
        }

        RoomResponseDTO responseDTO = RoomResponseDTO.builder()
                .roomNo(1001)
                .roomName("test1")
                .roomType("A")
                .remark("test1")
                .build();

        RoomResponseDTO responseDTO2 = RoomResponseDTO.builder()
                .roomNo(1002)
                .roomName("test2")
                .roomType("A")
                .remark("test2")
                .build();

        RoomResponseDTO responseDTO3 = RoomResponseDTO.builder()
                .roomNo(1003)
                .roomName("test3")
                .roomType("A")
                .remark("test3")
                .build();

        roomResponseList.add(responseDTO);
        roomResponseList.add(responseDTO2);
        roomResponseList.add(responseDTO3);

        return new PageImpl<>(roomResponseList, pageable, roomList.getTotalElements());
    }
}
