package org.reservation.system.room.interfaces;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomService;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomTypeService roomTypeService;

    @GetMapping("/testPage")
    public String showTestPage(Model model) {
        model.addAttribute("message", "first test!");
        return "testPage";
    }

    @GetMapping("/rooms")
    public String showRoomList(@ModelAttribute("roomSearchDTO") RoomSearchDTO roomSearchDTO, Model model, @PageableDefault(size = 15, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("RoomDTO", new RoomDTO());
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
    public String updateRoomForm(@PathVariable("id") Long id, Model model) {
        RoomDTO roomDTO = roomService.selectRoomById(id);
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("roomDTO", roomDTO);
        model.addAttribute("roomTypeList", roomTypeList);

        return "rooms/updateRoom";
    }

    @PostMapping("/rooms/new")
    public String createRoom(@ModelAttribute("RoomDTO") @Valid RoomDTO roomDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "rooms/createRoom";
        }
        roomService.createRoom(roomDTO);
        return "redirect:/rooms";
    }
}
