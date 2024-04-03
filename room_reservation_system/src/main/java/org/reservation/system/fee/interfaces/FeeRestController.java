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
    public ApiResponse<FeeDTO> getNewFee(FeeSearchDTO feeDTO) {

        //
//        feeService.createFee()

        return ApiResponse.<FeeDTO>builder()
                .status(HttpStatus.OK.toString())
                .message("메시지 넣어주기")
                .data(new FeeDTO())
                .build();
    }
}
