package org.reservation.system.room.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoomRestController {

    private final RoomService roomService;

    @GetMapping("/getRoomList")
    public ApiResponse<List<RoomResponseDTO>> getRoomList(@ModelAttribute("roomSearchDTO") RoomSearchDTO roomSearchDTO) {
        // 1. 객실 정보 조회
        List<RoomResponseDTO> roomResponseDTOList = roomService.selectRoomList(roomSearchDTO);
        return ApiResponse.<List<RoomResponseDTO>>builder()
                    .status(HttpStatus.OK.toString())
                    .message("room list fetched successfully")
                    .data(roomResponseDTOList)
                    .build();
    }

}
