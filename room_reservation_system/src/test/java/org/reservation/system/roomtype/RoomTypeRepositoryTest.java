package org.reservation.system.roomtype;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
class RoomTypeRepositoryTest {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;


    @Test
    void roomRepositoryIsNotNull() {
        Assertions.assertThat(roomTypeRepository).isNotNull();
        Assertions.assertThat(roomRepository).isNotNull();
    }

    @Test
    void 객실유형생성() {
        final RoomType roomType = RoomType.builder()
                .roomTypeCd("type_A")
                .build();

        RoomType result = roomTypeRepository.save(roomType);

        Assertions.assertThat(roomType.getRoomTypeCd()).isEqualTo(result.getRoomTypeCd());
    }

    @Test
    void 객실유형에따른_객실조회() {
        final RoomType roomType = RoomType.builder()
                .roomTypeCd("type")
                .build();

        RoomType saveRoomType = roomTypeRepository.saveAndFlush(roomType);

        Room build1 = Room.builder().roomNo(2001).roomName("TEST1").roomType(saveRoomType)
                .remark("test1").build();
        Room build2 = Room.builder().roomNo(2002).roomName("TEST2").roomType(saveRoomType)
                .remark("test2").build();
        Room build3 = Room.builder().roomNo(2003).roomName("TEST3").roomType(saveRoomType)
                .remark("test3").build();
        Room build4 = Room.builder().roomNo(2004).roomName("TEST4").roomType(saveRoomType)
                .remark("test4").build();
        Room build5 = Room.builder().roomNo(2005).roomName("TEST5").roomType(saveRoomType)
                .remark("test5").build();

        Room save1 = roomRepository.save(build1);
        Room save2 = roomRepository.save(build2);
        Room save3 = roomRepository.save(build3);
        Room save4 = roomRepository.save(build4);
        Room save5 = roomRepository.saveAndFlush(build5);

        List<Room> roomWithType = roomRepository.findAll();
        Assertions.assertThat(roomWithType).hasSize(5);

    }

}
