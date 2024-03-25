package org.reservation.system.room;

import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomRepository;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

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
    void 특정객실조회() {
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

        Room byRoomNo = roomRepository.findByRoomNo(1001).orElseThrow( () -> new EntityNotFoundException("tes!"));
        Assertions.assertThat(result.getRoomNo()).isEqualTo(byRoomNo.getRoomNo());
        Assertions.assertThat(result.getRoomType()).isEqualTo(byRoomNo.getRoomType());
        Assertions.assertThat(result.getRoomName()).isEqualTo(byRoomNo.getRoomName());
        Assertions.assertThat(result.getRemark()).isEqualTo(byRoomNo.getRemark());
    }

    @Test
    void 객실리스트조회() {
        final RoomType roomType = roomTypeRepository.saveAndFlush(new RoomType("A"));

        final Room room1 = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();
        final Room room2 = Room.builder()
                .roomNo(1002).roomType(roomType).roomName("A12").remark("test").build();
        final Room room3 = Room.builder()
                .roomNo(1003).roomType(roomType).roomName("A13").remark("test").build();
        final Room room4 = Room.builder()
                .roomNo(1004).roomType(roomType).roomName("A14").remark("test").build();
        final Room room5 = Room.builder()
                .roomNo(1005).roomType(roomType).roomName("A15").remark("test").build();

        final Room result1 = roomRepository.saveAndFlush(room1);
        final Room result2 = roomRepository.saveAndFlush(room2);
        final Room result3 = roomRepository.saveAndFlush(room3);
        final Room result4 = roomRepository.saveAndFlush(room4);
        final Room result5 = roomRepository.saveAndFlush(room5);

        List<Room> allBy = roomRepository.findAll();

        Assertions.assertThat(allBy).hasSize(5);
    }

    @Test
    void 객실리스트조회_페이징() {
        final RoomType roomType = roomTypeRepository.saveAndFlush(new RoomType("A"));

        final Room room1 = Room.builder()
                .roomNo(1001).roomType(roomType).roomName("A11").remark("test").build();
        final Room room2 = Room.builder()
                .roomNo(1002).roomType(roomType).roomName("A12").remark("test").build();
        final Room room3 = Room.builder()
                .roomNo(1003).roomType(roomType).roomName("A13").remark("test").build();
        final Room room4 = Room.builder()
                .roomNo(1004).roomType(roomType).roomName("A14").remark("test").build();
        final Room room5 = Room.builder()
                .roomNo(1005).roomType(roomType).roomName("A15").remark("test").build();

        final Room result1 = roomRepository.save(room1);
        final Room result2 = roomRepository.save(room2);
        final Room result3 = roomRepository.save(room3);
        final Room result4 = roomRepository.save(room4);
        final Room result5 = roomRepository.saveAndFlush(room5);

        Pageable pageable = PageRequest.of(0, 2);

        Page<Room> all = roomRepository.findAll(pageable);

        Assertions.assertThat(all.getNumber()).isZero();
        Assertions.assertThat(all.getSize()).isEqualTo(2);
        Assertions.assertThat(all.getContent()).isNotEmpty();

    }
}
