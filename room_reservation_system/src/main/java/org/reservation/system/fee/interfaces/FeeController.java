package org.reservation.system.fee.interfaces;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.service.FeeService;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FeeController {

    private final FeeService feeService;
    private final RoomTypeService roomTypeService;

    @GetMapping("/fees")
    public String showFeeList(@ModelAttribute("feeSearchDTO") FeeSearchDTO feeSearchDTO, Model model, @PageableDefault(size = 15, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<FeeResponseDTO> feeResponseList = feeService.selectFeeList(pageable, feeSearchDTO);
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("feeList", feeResponseList);
        model.addAttribute("roomTypeList", roomTypeList);

        return "/fees/feeList.html";
    }

    @GetMapping("/fees/new")
    public String showCreateFeeForm(Model model) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("feeDTO", new FeeDTO());
        model.addAttribute("roomTypeList", roomTypeList);

        return "fees/createFee";
    }

    @PostMapping("/fees/new")
    public String createFee(@ModelAttribute("feeDTO") @Valid FeeDTO feeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);
        if (bindingResult.hasErrors()) {
            return "fees/createFee";
        }
        feeService.createFee(feeDTO);

        redirectAttributes.addFlashAttribute("successMessage", "생성 성공!");

        return "redirect:/fees";
    }

    @GetMapping("/fees/update/{id}")
    public String getFeeUpdateForm(@PathVariable("id") Long id, Model model) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        FeeResponseDTO feeResponseDTO = feeService.selectFeeById(id);

        model.addAttribute("feeDTO", feeResponseDTO);

        return "/fees/updateFee";
    }

    @PostMapping("/fees/update/")
    public String updateFee(@ModelAttribute("feeDTO") @Valid FeeDTO feeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        if (bindingResult.hasErrors()) {
            return "fees/updateFee";
        }

        feeService.updateFee(feeDTO);
        model.addAttribute("feeDTO", feeDTO);
        redirectAttributes.addFlashAttribute("successMessage", "업데이트 성공!");

        return "/fees/updateFee";
    }
}
