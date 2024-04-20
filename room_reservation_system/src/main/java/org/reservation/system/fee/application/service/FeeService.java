package org.reservation.system.fee.application.service;

import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.reservation.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FeeService {
    Page<FeeResponseDTO> selectFeeList(Pageable pageable, FeeSearchDTO feeSearchDTO);
    List<FeeResponseDTO> selectFeeList(FeeSearchDTO feeSearchDTO);

    FeeResponseDTO createFee(FeeDTO feeDTO);
    FeeResponseDTO updateFee(FeeDTO feeDTO);
    FeeResponseDTO selectFeeById(Long id);
    void deleteFee(Long id);

    List<DailyRoomFeeDTO> makeFeeInfosForReservationByTempFee(Reservation reservation, FeeCreateVO feeCreateVO);

    List<DailyRoomFeeDTO> createTempFee(FeeSearchDTO feeSearchDTO);
}
