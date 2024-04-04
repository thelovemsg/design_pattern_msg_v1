package org.reservation.system.fee.domain.service;

import org.reservation.system.calander.domain.Calender;
import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.fee.domain.model.Fee;

import java.util.List;

public interface FeeDomainService {
    DailyFeeDTO createDailyFee(Fee Fee, Calender calender);
    List<DailyFeeDTO> createTempDailyFee(FeeSearchDTO feeSearchDTO);

    List<DailyFeeDTO> applyDiscountPolicy(Fee fee);
}
