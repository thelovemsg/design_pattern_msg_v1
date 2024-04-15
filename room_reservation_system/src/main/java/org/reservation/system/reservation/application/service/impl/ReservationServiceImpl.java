package org.reservation.system.reservation.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.DailyFeeDTO;
import org.reservation.system.fee.application.service.FeeService;
import org.reservation.system.fee.application.vo.FeeCreateVO;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.application.service.ReservationService;
import org.reservation.system.reservation.application.vo.RoomReservationQuery;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.repository.ReservationHistoryRepository;
import org.reservation.system.reservation.domain.repository.ReservationRepository;
import org.reservation.system.reservation.domain.service.ReservationDomainService;
import org.reservation.system.reservation.infrastructure.persistence.QueryReservationRepository;
import org.reservation.system.room.application.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDomainService reservationDomainService;
    private final QueryReservationRepository queryReservationRepository;
    private final RoomService roomService;
    private final FeeService feeService;
    private final ReservationRepository reservationRepository;
    private final ReservationHistoryRepository reservationHistoryRepository;

    @Override
    @Transactional
    public ReservationCreationDTO makeRoomReservation(ReservationCreationDTO creationDTO) {

        // 1. 현재 객실이 이미 예약중, 현재 객실이 블럭 상태인지 확인 => 내부적으로 에러 반환
        roomService.findIsRoomReservationPossible(new RoomReservationQuery(creationDTO.getRoomId(), creationDTO.getEnterRoomDate(), creationDTO.getStayDayCnt()));

        // 2. 예약 정보를 바탕으로 요금 정보를 생성한다.
        // => 임시 요금이 있으니 그것을 통해서 그대로 생성한다.
        List<DailyFeeDTO> dailyFeeDTOS = feeService.makeReservationFeeInfoList(
                FeeCreateVO.builder()
                        .roomNo(creationDTO.getRoomNo())
                        .roomTypeCd(creationDTO.getRoomTypeCd())
                        .custNo(creationDTO.getCustNo())
                        .enterRoomDate(creationDTO.getEnterRoomDate())
                        .stayDayCnt(creationDTO.getStayDayCnt())
                        .build());

        // 3. 해당 정보를 저장 및 반환한다.
        ReservationCreationDTO reservationCreationDTO = reservationDomainService.makeReservationInfo(creationDTO);

        reservationCreationDTO.setDailyFeeDTOS(dailyFeeDTOS);

        //3. 정보 세팅

        return reservationCreationDTO;
    }

    @Override
    public Page<ReservationDTO> selectReservationList(Pageable pageable, ReservationSearchDTO reservationSearchDTO) {
        List<Reservation> reservationWithComplexConditions = queryReservationRepository.findReservationWithComplexConditions(pageable, reservationSearchDTO);
        List<ReservationDTO> reservationDTOList = reservationWithComplexConditions.stream()
                                        .map(reservation -> ReservationDTO.ReservationToDTO(reservation)).toList();
        long total = queryReservationRepository.countReservationWithComplexConditions(reservationSearchDTO);
        return new PageImpl<>(reservationDTOList, pageable, total);
    }

    @Override
    @Transactional
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation does not exist"));
        return ReservationDTO.ReservationToDTO(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {

    }

}
