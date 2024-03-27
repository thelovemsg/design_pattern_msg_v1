package org.reservation.system.fee.application.service;

import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FeeService {
    Page<FeeResponseDTO> selectFeeList(Pageable pageable, FeeSearchDTO feeSearchDTO);
    FeeResponseDTO createFee(FeeDTO feeDTO);
    FeeResponseDTO updateFee(FeeDTO feeDTO);
    FeeResponseDTO selectFeeById(Long id);
    void deleteFee(Long id);
}
