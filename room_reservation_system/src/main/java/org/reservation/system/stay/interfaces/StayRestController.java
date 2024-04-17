package org.reservation.system.stay.interfaces;


import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StayRestController {


    @PostMapping("/stayList/search")
    public ApiResponse<Page<ReservationDTO>> getStayList() {
        // TODO : 현재 어떤 데이터를 화면에 뿌릴지 정확히 계산해야함.
        // DTO 나 Room 정보나 이런 것을 합산해서 보여줘야 하는데 현재 정해진게 없음.
        // 현재 상태에 따라서 어떤 색으로 보일지도 설정하면 좋겠고, 객실 타입에 따라서 객실 상태를 쭉 보여주면 좋겟음.

        return ApiResponse.<Page<ReservationDTO>>builder()
                .status("success")
                .message("Reservations fetched successfully.")
                .data(null)
                .build();
    }

}
