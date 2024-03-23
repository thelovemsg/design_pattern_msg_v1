package org.reservation.system.room.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomDTO;
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

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final QueryRoomRepository queryRoomRepository;

    @Override
    @Transactional
    public RoomResponseDTO createRoom(RoomDTO roomDTO) {
        RoomType roomType = roomTypeRepository.findByRoomTypeCd(roomDTO.getRoomTypeCd()).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomDTO.getRoomTypeCd()));
        if(roomType == null)
            throw new EntityNotFoundException("RoomType not found");

        final Room byRoomNo = roomRepository.findByRoomNo(roomDTO.getRoomNo());
        if(byRoomNo != null) {
            throw new IllegalArgumentException("ROOM_ALREADY_EXIST!!!");
        }

        Room newRoom = Room.builder().roomNo(roomDTO.getRoomNo()).roomName(roomDTO.getRoomName()).roomType(roomType).remark(roomDTO.getRemark()).build();
        Room savedRoom = roomRepository.save(newRoom);

        return RoomResponseDTO.builder()
                .id(savedRoom.getId())
                .roomTypeCd(savedRoom.getRoomType().getRoomTypeCd())
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
                        .id(room.getId())
                        .roomNo(room.getRoomNo())
                        .roomName(room.getRoomName())
                        .roomTypeCd(room.getRoomType().getRoomTypeCd())
                        .remark(room.getRemark())
                        .build())
                .toList();

        long total = queryRoomRepository.countWithComplexConditions(roomSearchDTO);


        return new PageImpl<>(roomResponseDTOs, pageable, total);
    }

    @Override
    public RoomDTO selectRoomById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Room not found with id " + id));

        return RoomDTO.builder()
                .id(room.getId())
                .roomTypeCd(room.getRoomType().getRoomTypeCd())
                .roomNo(room.getRoomNo())
                .roomName(room.getRoomName())
                .remark(room.getRemark())
                .build();
    }

    @Override
    public RoomResponseDTO updateRoom(RoomDTO roomDTO) {
        Room room = roomRepository.findById(roomDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Room not found with id " + roomDTO.getId()));
        RoomType roomType = roomTypeRepository.findByRoomTypeCd(roomDTO.getRoomTypeCd()).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomDTO.getRoomTypeCd()));
        room.changeRoomInfo(roomDTO, roomType);

        Room savedRoom = roomRepository.save(room);

        return RoomResponseDTO.builder()
                .id(room.getId())
                .roomTypeCd(savedRoom.getRoomType().getRoomTypeCd())
                .roomNo(room.getRoomNo())
                .roomName(room.getRoomName())
                .remark(room.getRemark())
                .build();
    }

}
