package org.reservation.system.room.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomCreationDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.QueryRoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final QueryRoomRepository queryRoomRepository;

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
    public Page<RoomResponseDTO> selectRoomList(Pageable pageable, RoomSearchDTO roomSearchDTO) {

        List<Room> roomList = queryRoomRepository.findWithComplexConditions(pageable, roomSearchDTO);
        List<RoomResponseDTO> roomResponseDTOs = roomList.stream()
                .map(room -> RoomResponseDTO.builder()
                        .roomNo(room.getRoomNo())
                        .roomName(room.getRoomName())
                        .roomType(room.getRoomType().getRoomTypeCd())
                        .remark(room.getRemark())
                        .build())
                .toList();

        long total = queryRoomRepository.countWithComplexConditions(roomSearchDTO);


        return new PageImpl<>(roomResponseDTOs, pageable, total);
    }
}
