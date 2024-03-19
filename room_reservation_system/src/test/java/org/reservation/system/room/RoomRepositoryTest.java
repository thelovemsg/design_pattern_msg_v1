package org.reservation.system.room;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
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

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Test
    void roomRepositoryIsNotNull() {
        Assertions.assertThat(roomRepository).isNotNull();
    }

    @Test
    void 객실정보등록() {
        // given
        RoomType roomType = roomTypeRepository.save(new RoomType("A"));

        final Room room = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();
        // when
        final Room result = roomRepository.save(room);

        // then
        Assertions.assertThat(result.getRoomNo()).isEqualTo(1001);
        Assertions.assertThat(result.getRoomType()).isEqualTo(roomType);
        Assertions.assertThat(result.getRoomName()).isEqualTo("A11");
        Assertions.assertThat(result.getRemark()).isEqualTo("test");
    }

    @Test
    void 객실조회() {
        final RoomType roomType = roomTypeRepository.save(new RoomType("A"));

        // given
        final Room room = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();

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
        final RoomType roomType = roomTypeRepository.save(new RoomType("A"));

        final Room room1 = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();

        // when
        final Room result = roomRepository.saveAndFlush(room1);

//        // then
        final Room room2 = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();

        Assertions.assertThatThrownBy(() -> roomRepository.saveAndFlush(room2))
                .isInstanceOf(DataIntegrityViolationException.class);

    }

    @Test
    void 객실번호조회() {
        // given
        final RoomType roomType = roomTypeRepository.saveAndFlush(new RoomType("A"));

        final Room room1 = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();

        // when
        final Room result = roomRepository.save(room1);

        Room byRoomNo = roomRepository.findByRoomNo(1001);
        Assertions.assertThat(result.getRoomNo()).isEqualTo(byRoomNo.getRoomNo());
        Assertions.assertThat(result.getRoomType()).isEqualTo(byRoomNo.getRoomType());
        Assertions.assertThat(result.getRoomName()).isEqualTo(byRoomNo.getRoomName());
        Assertions.assertThat(result.getRemark()).isEqualTo(byRoomNo.getRemark());
    }

}
