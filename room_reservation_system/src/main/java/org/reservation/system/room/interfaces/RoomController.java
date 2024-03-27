package org.reservation.system.room.interfaces;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.application.service.RoomTypeService;
import org.reservation.system.room.domain.repository.RoomRepository;
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
public class RoomController {

    private final RoomService roomService;
    private final RoomTypeService roomTypeService;
    private final RoomRepository roomRepository;

    @GetMapping("/testPage")
    public String showTestPage(Model model) {
        model.addAttribute("message", "first test!");
        return "testPage";
    }

    @GetMapping("/rooms")
    public String showRoomList(@ModelAttribute("roomSearchDTO") RoomSearchDTO roomSearchDTO, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<RoomResponseDTO> roomList = roomService.selectRoomList(pageable, roomSearchDTO);
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("roomList", roomList);
        model.addAttribute("roomTypeList", roomTypeList);

        return "rooms/roomList.html";
    }

    @GetMapping("/rooms/new")
    public String showCreateRoomForm(Model model) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("roomDTO", new RoomDTO());
        model.addAttribute("roomTypeList", roomTypeList);

        return "rooms/createRoom";
    }

    @GetMapping("/rooms/update/{id}")
    public String getRoomUpdateForm(@PathVariable("id") Long id, Model model) {
        RoomDTO roomDTO = roomService.selectRoomById(id);
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("roomDTO", roomDTO);
        model.addAttribute("roomTypeList", roomTypeList);

        return "rooms/updateRoom";
    }

    @PostMapping("/rooms/new")
    public String createRoom(@ModelAttribute("roomDTO") @Valid RoomDTO roomDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        roomRepository.findByRoomNo(roomDTO.getRoomNo()).ifPresent(room -> {
            bindingResult.rejectValue("roomNo", "error.roomDTO", "Room no already exists!");
        });

        roomRepository.findByRoomName(roomDTO.getRoomName()).ifPresent(room -> {
            bindingResult.rejectValue("roomName", "error.roomDTO", "Room name already exists!");
        });

        if (bindingResult.hasErrors()) {
            model.addAttribute("roomDTO", roomDTO);
            return "rooms/createRoom";
        }
        roomService.createRoom(roomDTO);
        redirectAttributes.addFlashAttribute("successMessage", "생성 성공!");
        return "redirect:/rooms";
    }

    @PostMapping("/rooms/update/")
    public String updateRoomInfo(@ModelAttribute("roomDTO") @Valid RoomDTO roomDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        roomRepository.findByRoomNo(roomDTO.getRoomNo()).ifPresent(room -> {
            if (!room.getId().equals(roomDTO.getId()))
                bindingResult.rejectValue("roomNo", "error.roomDTO", "Room no already exists!");
        });

        roomRepository.findByRoomName(roomDTO.getRoomName()).ifPresent(room -> {
            if (!room.getId().equals(roomDTO.getId()))
                bindingResult.rejectValue("roomName", "error.roomDTO", "Room name already exists!");
        });

        if (bindingResult.hasErrors()) {
            return "rooms/updateRoom";
        }
        roomService.updateRoom(roomDTO);
        model.addAttribute("roomDTO", roomDTO);
        redirectAttributes.addFlashAttribute("successMessage", "업데이트 성공!");

        return "redirect:/rooms/update/" + roomDTO.getId();
    }

    @DeleteMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        roomService.deleteRoom(id);
        redirectAttributes.addFlashAttribute("successMessage", "삭제 성공!");
        return "redirect:/rooms";
    }
}
