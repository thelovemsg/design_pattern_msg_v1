package org.reservation.system.fee.domain.service;

import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.vo.FeeCreateVO;

import java.util.List;

public interface FeeDomainService {
    List<DailyFeeDTO> createDailyFee(FeeCreateVO feeCreateVO);
}
