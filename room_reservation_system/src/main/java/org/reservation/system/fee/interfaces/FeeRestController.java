package org.reservation.system.fee.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.fee.application.dto.*;
import org.reservation.system.fee.application.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeeRestController {

    private final FeeService feeService;

    @GetMapping("/getFeeList")
    public ApiResponse<List<FeeResponseDTO>> getFeeList(@ModelAttribute("feeSearchDTO") FeeSearchDTO feeSearchDTO) {
        List<FeeResponseDTO> feeDTOList = feeService.selectFeeList(feeSearchDTO);

        return ApiResponse.<List<FeeResponseDTO>>builder()
                .status(HttpStatus.OK.toString())
                .message("성공")
                .data(feeDTOList)
                .build();
    }

    @PostMapping("/getTempFee")
    public ApiResponse<ReservationFeeResponseDTO> getNewFee(@RequestBody FeeSearchDTO feeSearchDTO) {

        List<DailyFeeDTO> tempFee = feeService.createTempFee(feeSearchDTO);

        BigDecimal allProductAmount = new BigDecimal("0");
        BigDecimal allDiscountAmount = new BigDecimal("0");
        BigDecimal allSalesAmount;

        for (DailyFeeDTO dailyFeeDTO : tempFee) {
            allProductAmount = allProductAmount.add(dailyFeeDTO.getProductAmount());
            allDiscountAmount = allDiscountAmount.add(dailyFeeDTO.getDiscountAmount());
        }

        allSalesAmount = allProductAmount.subtract(allDiscountAmount);

        return ApiResponse.<ReservationFeeResponseDTO>builder()
                .status(HttpStatus.OK.toString())
                .message("성공")
                .data(ReservationFeeResponseDTO.builder()
                        .productAmount(allProductAmount)
                        .discountAmount(allDiscountAmount)
                        .salesAmount(allSalesAmount)
                        .build())
                .build();
    }
}
