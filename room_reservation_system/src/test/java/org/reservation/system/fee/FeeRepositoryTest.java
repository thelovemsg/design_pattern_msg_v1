package org.reservation.system.fee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.fee.infrastructure.repository.FeeRepository;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.RoomRepository;
import org.reservation.system.room.infrastructure.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static java.lang.Boolean.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("dev")
class FeeRepositoryTest {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;


    @Test
    void feeRepositoryInjectionIsNotNull() {
        Assertions.assertThat(feeRepository).isNotNull();
        Assertions.assertThat(roomTypeRepository).isNotNull();
    }

    @Test
    void 요금생성() {

        RoomType roomType = roomTypeRepository.saveAndFlush(new RoomType("TYPE_A"));

        Fee newFee = Fee.builder().feeName("표준가").isUsed(TRUE).remark("표준가1").roomType(roomType)
                .feeAmount(new BigDecimal(100000)).build();

        Fee savedFee = feeRepository.save(newFee);

        Assertions.assertThat(savedFee).isNotNull();
        Assertions.assertThat(savedFee.getFeeAmount()).isEqualTo(new BigDecimal(100000));
        Assertions.assertThat(savedFee.getFeeName()).isEqualTo("표준가");
        Assertions.assertThat(savedFee.getRemark()).isEqualTo("표준가1");
        Assertions.assertThat(savedFee.getRoomType()).isEqualTo(roomType);
    }


}
