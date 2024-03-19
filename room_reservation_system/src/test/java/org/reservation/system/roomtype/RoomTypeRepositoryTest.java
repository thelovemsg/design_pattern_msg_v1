package org.reservation.system.roomtype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
class RoomTypeRepositoryTest {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Test
    void roomRepositoryIsNotNull() {
        Assertions.assertThat(roomTypeRepository).isNotNull();
    }

    @Test
    void 객실유형생성() {
        final RoomType roomType = RoomType.builder()
                .roomTypeCd("type")
                .build();

        RoomType result = roomTypeRepository.save(roomType);

        Assertions.assertThat(roomType.getRoomTypeCd()).isEqualTo(result.getRoomTypeCd());

    }

}
