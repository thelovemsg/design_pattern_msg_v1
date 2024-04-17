package org.reservation.system.reservation.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.application.dto.ReservationHistoryDTO;
import org.reservation.system.reservation.application.dto.ReservationHistorySearchDTO;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.application.service.ReservationHistoryService;
import org.reservation.system.reservation.application.service.ReservationService;
import org.reservation.system.reservation.domain.repository.ReservationHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReservationRestController {

    private final ReservationService reservationService;
    private final ReservationHistoryService reservationHistoryService;

    @PostMapping("/reservations/search")
    public ApiResponse<Page<ReservationDTO>> getReservationList(@RequestBody ReservationSearchDTO reservationSearchDTO, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReservationDTO> reservationResponseList = reservationService.selectReservationList(pageable, reservationSearchDTO);
        return ApiResponse.<Page<ReservationDTO>>builder()
                .status(HttpStatus.OK)
                .message("Reservations fetched successfully.")
                .data(reservationResponseList)
                .build();
    }

    @PostMapping("/reservations/reservationHistory")
    public ApiResponse<Page<ReservationHistoryDTO>> getReservationHistory(@RequestBody ReservationHistorySearchDTO reservationHistorySearchDTO, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        // TODO : 히스토리 조회 잘 되는지 확인하기
        Page<ReservationHistoryDTO> reservationHistoryList = reservationHistoryService.selectReservationHistoryList(pageable, reservationHistorySearchDTO);
        return ApiResponse.<Page<ReservationHistoryDTO>>builder()
                .status(HttpStatus.OK)
                .message("Reservations fetched successfully.")
                .data(reservationHistoryList)
                .build();
    }

}
