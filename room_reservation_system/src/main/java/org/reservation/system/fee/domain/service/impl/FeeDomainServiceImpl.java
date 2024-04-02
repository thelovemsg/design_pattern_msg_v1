package org.reservation.system.fee.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.fee.domain.repository.FeeRepository;
import org.reservation.system.fee.domain.service.FeeDomainService;
import org.reservation.system.fee.infrastructure.persistence.QueryFeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeDomainServiceImpl implements FeeDomainService {

    private final FeeRepository feeRepository;
    private final QueryFeeRepository queryFeeRepository;

    @Override
    public List<DailyFeeDTO> createDailyFee(FeeCreateVO feeCreateVO) {
        // TODO
        // 1. 예약하려는 객실의 요금을 찾는다.
        // 2. 예약하는 기간에 맞는 요금을 만들어 낸다.
        // 3. 해당 예약 일이

        return null;
    }
}

