package org.reservation.system.fee.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.service.FeeService;
import org.reservation.system.room.application.dto.RoomDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class FeeController {

    private final FeeService feeService;

    @GetMapping("/fees")
    public String showFeeList(@ModelAttribute("feeSearchDTO") FeeSearchDTO feeSearchDTO, Model model, @PageableDefault(size = 15, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("feeDTO", new RoomDTO());
        Page<FeeResponseDTO> feeResponseDTOS = feeService.selectFeeList(pageable, feeSearchDTO);

        model.addAttribute("feeList", feeResponseDTOS);

        return "fees/feeList.html";

    }
}
