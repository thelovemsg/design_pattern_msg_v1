package org.reservation.system.reservation.application.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.DailyRoomFeeDTO;
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
import org.reservation.system.room.application.dto.RoomDTO;
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
    public ReservationDTO makeRoomReservation(ReservationDTO reservationDTO) {

        // 객실 정보 조회
        RoomDTO roomIdByRoomNo = roomService.findRoomIdByRoomNo(reservationDTO.getRoomNo());

        // 1. 현재 객실이 이미 예약중인지, 블럭 상태인지 확인 => 내부적으로 에러 반환
        roomService.findIsRoomReservationPossible(new RoomReservationQuery(roomIdByRoomNo.getId(), reservationDTO.getEnterRoomDate(), reservationDTO.getStayDayCnt()));

        Reservation reservation = reservationDomainService.makeReservationInfo(reservationDTO);

        FeeCreateVO fee = FeeCreateVO.builder()
                .roomNo(reservationDTO.getRoomNo())
                .roomTypeCd(reservationDTO.getRoomTypeCd())
                .custNo(reservationDTO.getCustNo())
                .enterRoomDate(reservationDTO.getEnterRoomDate())
                .stayDayCnt(reservationDTO.getStayDayCnt())
                .build();

        List<DailyRoomFeeDTO> dailyRoomFeeDTOList = feeService.makeFeeInfosForReservationByTempFee(reservation, fee);

        return Reservation.entityToDTO(reservation, dailyRoomFeeDTOList);
    }

    @Override
    public Page<ReservationDTO> selectReservationList(Pageable pageable, ReservationSearchDTO reservationSearchDTO) {
        List<Reservation> reservationWithComplexConditions = queryReservationRepository.findReservationWithComplexConditions(pageable, reservationSearchDTO);
        List<ReservationDTO> reservationDTOList = reservationWithComplexConditions.stream()
                .map(entity -> Reservation.entityToDTO(entity, null)).toList();
        long total = queryReservationRepository.countReservationWithComplexConditions(reservationSearchDTO);
        return new PageImpl<>(reservationDTOList, pageable, total);
    }

    @Override
    @Transactional
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("reservation does not exist"));
        return Reservation.entityToDTO(reservation, null);
    }

    @Override
    public void updateReservation(Reservation reservation) {

    }

}
