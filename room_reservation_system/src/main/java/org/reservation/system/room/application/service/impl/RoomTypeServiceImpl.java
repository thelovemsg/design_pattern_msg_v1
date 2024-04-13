package org.reservation.system.room.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomTypeService;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomTypeResponseDTO> selectAllRoomType() {
        List<RoomType> roomTypeList = roomTypeRepository.findByDeletedIsFalse();
        List<RoomTypeResponseDTO> roomTypeResponseDTOList = new ArrayList<>();

        for (RoomType roomType : roomTypeList) {
            roomTypeResponseDTOList.add(RoomTypeResponseDTO.builder()
                    .id(roomType.getId())
                    .roomTypeCd(roomType.getRoomTypeCd())
                    .build());
        }

        return roomTypeResponseDTOList;
    }
}
