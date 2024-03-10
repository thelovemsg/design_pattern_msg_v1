package org.reservation.system.room;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.room.domain.Room;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

}
