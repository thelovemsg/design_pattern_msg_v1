package org.reservation.system.reservation.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.application.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReservationRestController {

    private final ReservationService reservationService;

    @PostMapping("/reservations/search")
    public ApiResponse<Page<ReservationDTO>> getReservationList(@RequestBody ReservationSearchDTO reservationSearchDTO, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReservationDTO> reservationResponseList = reservationService.selectReservationList(pageable, reservationSearchDTO);
        return ApiResponse.<Page<ReservationDTO>>builder()
                .status("success")
                .message("Reservations fetched successfully.")
                .data(reservationResponseList)
                .build();
    }

}
