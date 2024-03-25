package org.reservation.system.fee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.service.impl.FeeServiceImpl;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.fee.domain.repository.FeeRepository;
import org.reservation.system.fee.infrastructure.persistence.QueryFeeRepository;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("dev")
public class FeeServiceTest {

    @Mock
    private FeeRepository feeRepository;

    @Mock
    private RoomTypeRepository roomTypeRepository;

    @Mock
    private QueryFeeRepository queryFeeRepository;


    @InjectMocks
    private FeeServiceImpl feeService;

    @Test
    void mockMvcIsNotNull() {
        assertThat(feeRepository).isNotNull();
        assertThat(roomTypeRepository).isNotNull();
        assertThat(feeService).isNotNull();
    }

    @Test
    void 요금정보조회() {

        RoomType roomType = new RoomType();

        Fee fee1 = Fee.builder()
                .feeName("TYPE_A_FEE_NAME_1")
                .isUsed(Boolean.TRUE)
                .remark("TYPE_A_REMARK_1")
                .feeAmount(new BigDecimal(100000))
                .roomType(roomType).build();

        Fee fee2 = Fee.builder()
                .feeName("TYPE_A_FEE_NAME_2")
                .feeAmount(new BigDecimal(110000))
                .isUsed(Boolean.TRUE)
                .remark("TYPE_A_REMARK_2")
                .roomType(roomType).build();

        Fee fee3 = Fee.builder()
                .feeName("TYPE_A_FEE_NAME_3")
                .feeAmount(new BigDecimal(120000))
                .isUsed(Boolean.TRUE)
                .remark("TYPE_A_REMARK_3")
                .roomType(roomType).build();

        PageRequest pageRequest = PageRequest.of(0, 4);

        FeeSearchDTO feeSearchDTO = new FeeSearchDTO();

        when(queryFeeRepository.findFeeWithComplexConditions(pageRequest, feeSearchDTO)).thenReturn(List.of(fee1, fee2, fee3));

        Page<FeeResponseDTO> pageList = feeService.selectFeeList(pageRequest, feeSearchDTO);

        Assertions.assertThat(pageList.getSize()).isEqualTo(3);

    }

}
