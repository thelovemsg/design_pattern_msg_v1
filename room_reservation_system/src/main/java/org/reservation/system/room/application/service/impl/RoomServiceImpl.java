package org.reservation.system.room.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.vo.RoomReservationQuery;
import org.reservation.system.room.application.dto.RoomCurrentStatusDTO;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.application.vo.RoomBlockVO;
import org.reservation.system.room.application.vo.RoomVO;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomRepository;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.reservation.system.room.domain.service.RoomDomainService;
import org.reservation.system.room.infrastructure.persistence.QueryRoomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final QueryRoomRepository queryRoomRepository;
    private final RoomDomainService roomDomainService;

    @Override
    @Transactional
    public RoomResponseDTO createRoom(RoomDTO roomDTO) {
        RoomType roomType = roomTypeRepository.findByRoomTypeCdAndDeletedIsFalse(roomDTO.getRoomTypeCd()).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomDTO.getRoomTypeCd()));

        roomRepository.findByRoomNoAndDeletedIsFalse(roomDTO.getRoomNo())
                .ifPresent(room -> {
                    throw new IllegalArgumentException("Room number " + roomDTO.getRoomNo() + " already exists!");
                });

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
    @Transactional
    public Page<RoomResponseDTO> selectRoomList(Pageable pageable, RoomSearchDTO roomSearchDTO) {

        List<Room> roomList = queryRoomRepository.findRoomWithComplexConditions(pageable, roomSearchDTO);
        List<RoomResponseDTO> roomResponseDTOs = roomList.stream()
                .map(room -> RoomResponseDTO.builder()
                        .id(room.getId())
                        .roomNo(room.getRoomNo())
                        .roomName(room.getRoomName())
                        .roomTypeCd(room.getRoomType().getRoomTypeCd())
                        .remark(room.getRemark())
                        .build())
                .toList();

        long total = queryRoomRepository.countRoomWithComplexConditions(roomSearchDTO);

        return new PageImpl<>(roomResponseDTOs, pageable, total);
    }

    @Override
    @Transactional
    public RoomDTO selectRoomById(Long id) {
        Room room = roomRepository.findByIdAndDeletedIsFalse(id).orElseThrow(() -> new EntityNotFoundException("Room not found with id " + id));

        return RoomDTO.builder()
                .id(room.getId())
                .roomTypeCd(room.getRoomType().getRoomTypeCd())
                .roomNo(room.getRoomNo())
                .roomName(room.getRoomName())
                .remark(room.getRemark())
                .build();
    }

    @Override
    @Transactional
    public RoomResponseDTO updateRoom(RoomDTO roomDTO) {
        Room room = roomRepository.findByIdAndDeletedIsFalse(roomDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Room not found with id " + roomDTO.getId()));
        RoomType roomType = roomTypeRepository.findByRoomTypeCdAndDeletedIsFalse(roomDTO.getRoomTypeCd()).orElseThrow(() -> new EntityNotFoundException("RoomType not found with typeCd " + roomDTO.getRoomTypeCd()));
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

    @Override
    public List<RoomResponseDTO> selectRoomList(RoomSearchDTO roomSearchDTO) {
        return roomTypeRepository.findByRoomTypeCdAndDeletedIsFalse(roomSearchDTO.getRoomTypeCd())
                .map(roomType -> roomRepository.findByRoomTypeAndDeletedIsFalse(roomType)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(RoomResponseDTO::convertRoomToDTO)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new EntityNotFoundException("Room type does not exist!"));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void deleteRoom(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with id " + id));
        room.delete();
        roomRepository.save(room);
    }

    @Override
    public void findIsRoomReservationPossible(RoomReservationQuery roomReservationQuery) {
        List<RoomVO> reservedInfoRoomList = roomDomainService.findRoomIsReserved(roomReservationQuery);
        if (!reservedInfoRoomList.isEmpty()) {
            throw new IllegalArgumentException("이미 예약됌");
        }

        RoomBlockVO roomIsBlocked = roomDomainService.findRoomIsBlocked(roomReservationQuery);
        if(roomIsBlocked != null) {
            throw new IllegalArgumentException("객실이 블록처리됌");
        }

    }

    @Override
    public List<RoomCurrentStatusDTO> selectRoomCurrentStatusByType(RoomSearchDTO roomSearchDTO) {
        return queryRoomRepository.findRoomCurrentStatusByRoomTypes(roomSearchDTO);
    }

}
