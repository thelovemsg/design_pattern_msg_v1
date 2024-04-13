package org.reservation.system.fee.interfaces;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.application.dto.FeeDTO;
import org.reservation.system.fee.application.dto.FeeResponseDTO;
import org.reservation.system.fee.application.dto.FeeSearchDTO;
import org.reservation.system.fee.application.service.FeeService;
import org.reservation.system.fee.domain.repository.FeeRepository;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FeeController {

    private final FeeService feeService;
    private final RoomTypeService roomTypeService;
    private final FeeRepository feeRepository;

    @GetMapping("/fees")
    public String showFeeList(@ModelAttribute("feeSearchDTO") FeeSearchDTO feeSearchDTO, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<FeeResponseDTO> feeResponseList = feeService.selectFeeList(pageable, feeSearchDTO);
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("feeList", feeResponseList);
        model.addAttribute("feeSearchDTO", feeSearchDTO);
        model.addAttribute("roomTypeList", roomTypeList);

        return "pages/fees/feeList";
    }

    @GetMapping("/fees/new")
    public String showCreateFeeForm(Model model) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("feeDTO", new FeeDTO());
        model.addAttribute("roomTypeList", roomTypeList);

        return "pages/fees/createFee";
    }

    @PostMapping("/fees/new")
    public String createFee(@ModelAttribute("feeDTO") @Valid FeeDTO feeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        feeRepository.findByFeeName(feeDTO.getFeeName()).ifPresent(fee -> {
            if(!fee.getId().equals(feeDTO.getId()))
                bindingResult.rejectValue("feeName", "error.feeDTO", "Fee name already exists!");
        });

        if (bindingResult.hasErrors()) {
            return "pages/fees/createFee";
        }
        feeService.createFee(feeDTO);

        redirectAttributes.addFlashAttribute("successMessage", "생성 성공!");

        return "redirect:/pages/fees";
    }

    @GetMapping("/fees/update/{id}")
    public String getFeeUpdateForm(@PathVariable("id") Long id, Model model) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        FeeResponseDTO feeResponseDTO = feeService.selectFeeById(id);

        model.addAttribute("feeDTO", feeResponseDTO);

        return "pages/fees/updateFee";
    }

    @PostMapping("/fees/update")
    public String updateFee(@ModelAttribute("feeDTO") @Valid FeeDTO feeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        feeRepository.findByFeeName(feeDTO.getFeeName()).ifPresent(fee -> {
            if(!fee.getId().equals(feeDTO.getId()))
                bindingResult.rejectValue("feeName", "error.feeDTO", "Fee name already exists!");
        });

        if (bindingResult.hasErrors()) {
            return "pages/fees/updateFee";
        }

        feeService.updateFee(feeDTO);
        model.addAttribute("feeDTO", feeDTO);
        redirectAttributes.addFlashAttribute("successMessage", "업데이트 성공!");

        return "redirect:/pages/fees/update/" + feeDTO.getId();
    }

    @DeleteMapping("/fees/{id}")
    public String deleteFee(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        feeService.deleteFee(id);
        redirectAttributes.addFlashAttribute("successMessage", "삭제 성공!");
        return "redirect:/pages/fees";
    }
}