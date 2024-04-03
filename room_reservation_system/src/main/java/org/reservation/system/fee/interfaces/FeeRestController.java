package org.reservation.system.fee.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeeRestController {

    private final FeeService feeService;

    @GetMapping("/fee")
    public ApiResponse<FeeDTO> getNewFee(FeeSearchDTO feeSearchDTO) {

        //요금 정보를 바탕으로 임시 요금을 생성해서 총 요금을 반환한다.
        //실제로 임시 요금은 일별로 생성이 되지만 사용자 입장에서는 총 가격만 알면 되기에 총 가격만 반환한다.
        feeService.createTempFee(feeSearchDTO);

        return ApiResponse.<FeeDTO>builder()
                .status(HttpStatus.OK.toString())
                .message("메시지 넣어주기")
                .data(new FeeDTO())
                .build();
    }
}
