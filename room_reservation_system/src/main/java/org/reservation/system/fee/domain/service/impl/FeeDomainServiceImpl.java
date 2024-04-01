package org.reservation.system.fee.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.fee.domain.service.FeeDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeDomainServiceImpl implements FeeDomainService {

    @Override
    public List<DailyFeeDTO> createFeeDailyFee(FeeCreateVO feeCreateVO) {
        return null;
    }
}

