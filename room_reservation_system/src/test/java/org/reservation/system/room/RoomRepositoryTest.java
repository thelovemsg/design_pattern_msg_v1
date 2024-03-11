package org.reservation.system.room;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.room.domain.Room;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void roomRepositoryIsNotNull() {
        Assertions.assertThat(roomRepository).isNotNull();
    }

    @Test
    void 객실정보등록() {
        // given

        final Room room = Room.builder()
                .roomNo(1001).roomType("D45").roomName("A11").remark("test").build();
        // when
        final Room result = roomRepository.save(room);

        // then
        Assertions.assertThat(result.getRoomNo()).isEqualTo(1001);
        Assertions.assertThat(result.getRoomType()).isEqualTo("D45");
        Assertions.assertThat(result.getRoomName()).isEqualTo("A11");
        Assertions.assertThat(result.getRemark()).isEqualTo("test");
    }

    @Test
    void 객실조회() {
        // given
        final Room room = Room.builder()
                .roomNo(1001).roomType("D45").roomName("A11").remark("test").build();

        // when
        final Room result = roomRepository.save(room);
        Room foundRoom = roomRepository.findById(result.getId()).orElseThrow(() -> new IllegalArgumentException("no room"));

        // then
        Assertions.assertThat(result.getRoomNo()).isEqualTo(foundRoom.getRoomNo());
        Assertions.assertThat(result.getRoomType()).isEqualTo(foundRoom.getRoomType());
        Assertions.assertThat(result.getRoomName()).isEqualTo(foundRoom.getRoomName());
        Assertions.assertThat(result.getRemark()).isEqualTo(foundRoom.getRemark());
    }

    @Test
    void 이미있는객실() {
        // given
        final Room room1 = Room.builder()
                .roomNo(1001).roomType("D45").roomName("A11").remark("test").build();

        // when
        final Room result = roomRepository.saveAndFlush(room1);

//        // then
        Assertions.assertThatThrownBy(() -> {
            final Room room2 = Room.builder()
                    .roomNo(1001).roomType("D45").roomName("A11").remark("test").build();
            roomRepository.saveAndFlush(room2); // 두 번째 객체 저장 시도 후 즉시 flush
        }).isInstanceOf(DataIntegrityViolationException.class);

    }

    @Test
    public void 객실번호조회() {
        // given
        final Room room1 = Room.builder()
                .roomNo(1001).roomType("D45").roomName("A11").remark("test").build();

        // when
        final Room result = roomRepository.save(room1);

        Room byRoomNo = roomRepository.findByRoomNo(1001);
        Assertions.assertThat(result.getRoomNo()).isEqualTo(byRoomNo.getRoomNo());
        Assertions.assertThat(result.getRoomType()).isEqualTo(byRoomNo.getRoomType());
        Assertions.assertThat(result.getRoomName()).isEqualTo(byRoomNo.getRoomName());
        Assertions.assertThat(result.getRemark()).isEqualTo(byRoomNo.getRemark());
    }

}
