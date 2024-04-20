package org.reservation.system.fee.domain.service;

import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.reservation.domain.model.Reservation;

import java.util.List;

public interface FeeDomainService {
    List<DailyRoomFeeDTO> createTempDailyFee(FeeSearchDTO feeSearchDTO);
    List<DailyRoomFeeDTO> applyDiscountPolicy(Fee fee);
    List<DailyRoomFeeDTO> createDailyRoomFeeByTemp(Reservation reservation, FeeCreateVO feeCreateVO);
}
