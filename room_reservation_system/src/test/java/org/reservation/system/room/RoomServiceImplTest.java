package org.reservation.system.room;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.service.impl.RoomServiceImpl;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")
class RoomServiceImplTest {

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private RoomTypeRepository roomTypeRepository;

    @InjectMocks
    private RoomServiceImpl roomService;

    @Test
    void 객실저장() {
        lenient().doReturn(null).when(roomRepository).findByRoomNo(1001);
        lenient().doReturn(new Room()).when(roomRepository).save(any(Room.class));

//        // save 메소드 호출 시 Room 객체를 반환하도록 설정합니다. 이 객체에는 RoomResponse 객체 생성에 필요한 모든 정보가 포함되어 있어야 합니다.
        RoomDTO mockRoom = RoomDTO.builder()
                .roomNo(1001)
                .roomName("객실1")
                .roomTypeCd("A")
                .remark("객실생성1")
                .build();

        RoomResponseDTO response = RoomResponseDTO.builder().roomNo(1001)
                .roomTypeCd("D22")
                .roomName("객실1")
                .remark("객실생성1").build();

        Room room = Room.builder()
                .roomNo(1001)
                .roomType(new RoomType("A"))
                .roomName("객실1")
                .remark("객실생성1")
                .build();
//
        when(roomRepository.save(any(Room.class))).thenReturn(room);
//
//        // when: 서비스 메소드를 호출합니다.
        RoomResponseDTO result = roomService.createRoom(mockRoom);
//
//        // then: 반환된 RoomResponse 객체의 내용을 검증합니다.
        assertThat(result).isNotNull();
        assertThat(result.getRoomNo()).isEqualTo(1001);
        assertThat(result.getRoomTypeCd()).isEqualTo("A");
        assertThat(result.getRoomName()).isEqualTo("객실1");
        assertThat(result.getRemark()).isEqualTo("객실생성1");
//
//        // verify: roomRepository의 findByRoomNo와 save 메소드가 적절히 호출되었는지 확인합니다.
        verify(roomRepository, times(1)).findByRoomNo(1001);
        verify(roomRepository, times(1)).save(any(Room.class));
    }

    @Test
    void 객실이이미존재() {
        // 이미 존재하는 객실 정보 모의
        RoomType existingRoomType = new RoomType("A");

        Room existingRoom = Room.builder()
                .roomNo(1001)
                .roomName("Existing Room")
                .roomType(existingRoomType)
                .remark("Remark")
                .build();

        // findByRoomNo 호출 시 이미 존재하는 Room 객체 반환
        when(roomRepository.findByRoomNo(1001)).thenReturn(existingRoom);
        when(roomTypeRepository.findByRoomTypeCd("A")).thenReturn(existingRoomType);

        // RoomDTO 준비
        RoomDTO newRoomDTO = RoomDTO.builder()
                .roomNo(1001) // 이미 존재하는 번호
                .roomName("New Room")
                .roomTypeCd("A")
                .remark("Remark")
                .build();

        // createRoom 호출 시 예외가 발생하는지 검증
        Assertions.assertThatThrownBy(() -> roomService.createRoom(newRoomDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ROOM_ALREADY_EXIST");

        // findByRoomNo가 호출되었는지 확인
        verify(roomRepository).findByRoomNo(1001);
        verify(roomTypeRepository).findByRoomTypeCd("A");
    }

    @Test
    @Transactional
    void 객실조회_페이징() {

        PageRequest pageRequest = PageRequest.of(0, 3);
        RoomType roomType = new RoomType("A");
        Room build1 = Room.builder().roomNo(1001).roomName("test1").roomType(roomType).build();
        Room build2 = Room.builder().roomNo(1001).roomName("test1").roomType(roomType).build();
        when(roomRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(List.of(build1, build2)));

        Page<RoomResponseDTO> roomResponseDTOS = roomService.selectRoomList(pageRequest, new RoomSearchDTO());

        assertThat(roomResponseDTOS).isNotNull();
        assertThat(roomResponseDTOS.getSize()).isEqualTo(3); // 페이지 당 크기 검증
        assertThat(roomResponseDTOS.getContent()).hasSize(2); // 실제 반환된 컨텐츠 크기 검증
        assertThat(roomResponseDTOS.getContent()).hasSizeLessThanOrEqualTo(3); // 실제 반환된 컨텐츠 크기 검증
        assertThat(roomResponseDTOS.getNumber()).isZero(); // 페이지 번호 검증

        verify(roomRepository).findAll(any(Pageable.class));

    }

}
