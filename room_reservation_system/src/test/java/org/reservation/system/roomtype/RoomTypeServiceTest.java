package org.reservation.system.roomtype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.impl.RoomTypeServiceImpl;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")
class RoomTypeServiceTest {

    @Mock
    private RoomTypeRepository roomTypeRepository;

    @InjectMocks
    private RoomTypeServiceImpl roomTypeService;

    @Test
    void 객실타입목록조회() {

        when(roomTypeRepository.findAll()).thenReturn(List.of(new RoomType("A"), new RoomType("B")));
        List<RoomTypeResponseDTO> allRoomType = roomTypeService.selectAllRoomType();

        Assertions.assertThat(allRoomType).hasSize(2);
    }
}
