package org.reservation.system.room;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reservation.system.room.application.dto.RoomCreationDTO;
import org.reservation.system.room.application.dto.RoomResponse;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.domain.Room;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")
class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    void 객실저장() {
        lenient().doReturn(null).when(roomRepository).findByRoomNo(1001);
        lenient().doReturn(new Room()).when(roomRepository).save(any(Room.class));

//        // save 메소드 호출 시 Room 객체를 반환하도록 설정합니다. 이 객체에는 RoomResponse 객체 생성에 필요한 모든 정보가 포함되어 있어야 합니다.
        RoomCreationDTO mockRoom = RoomCreationDTO.builder()
                .roomNo(1001)
                .roomName("객실1")
                .roomType("D22")
                .remark("객실생성1")
                .build();

        RoomResponse response = RoomResponse.builder().roomNo(1001)
                .roomType("D22")
                .roomName("객실1")
                .remark("객실생성1").build();

        Room room = Room.builder()
                .roomNo(1001)
                .roomType("D22")
                .roomName("객실1")
                .remark("객실생성1")
                .build();
//
        when(roomRepository.save(any(Room.class))).thenReturn(room);
//
//        // when: 서비스 메소드를 호출합니다.
        RoomResponse result = roomService.createRoom(mockRoom);
//
//        // then: 반환된 RoomResponse 객체의 내용을 검증합니다.
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getRoomNo()).isEqualTo(1001);
        Assertions.assertThat(result.getRoomType()).isEqualTo("D22");
        Assertions.assertThat(result.getRoomName()).isEqualTo("객실1");
        Assertions.assertThat(result.getRemark()).isEqualTo("객실생성1");
//
//        // verify: roomRepository의 findByRoomNo와 save 메소드가 적절히 호출되었는지 확인합니다.
        verify(roomRepository, times(1)).findByRoomNo(1001);
        verify(roomRepository, times(1)).save(any(Room.class));
    }

    @Test
    void 객실이이미존재() {
        // 이미 존재하는 객실 정보 모의
        Room existingRoom = Room.builder()
                .roomNo(1001)
                .roomName("Existing Room")
                .roomType("Type")
                .remark("Remark")
                .build();

        // findByRoomNo 호출 시 이미 존재하는 Room 객체 반환
        when(roomRepository.findByRoomNo(1001)).thenReturn(existingRoom);

        // RoomCreationDTO 준비
        RoomCreationDTO newRoomDTO = RoomCreationDTO.builder()
                .roomNo(1001) // 이미 존재하는 번호
                .roomName("New Room")
                .roomType("Type")
                .remark("Remark")
                .build();

        // createRoom 호출 시 예외가 발생하는지 검증
        Assertions.assertThatThrownBy(() -> roomService.createRoom(newRoomDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("ROOM_ALREADY_EXIST");

        // findByRoomNo가 호출되었는지 확인
        verify(roomRepository).findByRoomNo(1001);
//
    }

}
