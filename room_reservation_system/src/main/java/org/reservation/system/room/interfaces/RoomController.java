package org.reservation.system.room.interfaces;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.application.dto.RoomCreationDTO;
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
        model.addAttribute("roomCreationDto", new RoomCreationDTO());
        Page<RoomResponseDTO> roomList = roomService.selectRoomList(pageable, roomSearchDTO);
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();

        model.addAttribute("roomList", roomList);
        model.addAttribute("roomTypeList", roomTypeList);

        return "rooms/roomList.html";
    }

    @GetMapping("/rooms/new")
    public String showCreateRoomForm(Model model) {
        model.addAttribute("roomCreationDto", new RoomCreationDTO());
        return "rooms/createRoom";
    }

    @PostMapping("/rooms/new")
    public String createRoom(@ModelAttribute("roomCreationDto") @Valid RoomCreationDTO roomCreationDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "rooms/createRoom";
        }
        roomService.createRoom(roomCreationDto);
        return "redirect:/rooms";
    }
}
