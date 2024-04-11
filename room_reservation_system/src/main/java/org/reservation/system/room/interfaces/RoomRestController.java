package org.reservation.system.room.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.common.api.ApiResponse;
import org.reservation.system.room.application.dto.RoomCurrentStatusDTO;
import org.reservation.system.room.application.dto.RoomResponseDTO;
import org.reservation.system.room.application.dto.RoomSearchDTO;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomService;
import org.reservation.system.room.application.service.RoomTypeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoomRestController {

    private final RoomService roomService;
    private final RoomTypeService roomTypeService;

    @GetMapping("/getRoomList")
    public ApiResponse<List<RoomResponseDTO>> getRoomList(@ModelAttribute("roomSearchDTO") RoomSearchDTO roomSearchDTO) {
        List<RoomResponseDTO> roomResponseDTOList = roomService.selectRoomList(roomSearchDTO);
        return ApiResponse.<List<RoomResponseDTO>>builder()
                    .status(HttpStatus.OK.toString())
                    .message("room list fetched successfully")
                    .data(roomResponseDTOList)
                    .build();
    }

    @GetMapping("/getRoomTypeList")
    public ApiResponse<List<RoomTypeResponseDTO>> getRoomTypeList() {
        List<RoomTypeResponseDTO> roomTypeResponseDTOList = roomTypeService.selectAllRoomType();
        return ApiResponse.<List<RoomTypeResponseDTO>>builder()
                .status(HttpStatus.OK.toString())
                .message("room list fetched successfully")
                .data(roomTypeResponseDTOList)
                .build();
    }

    @PostMapping("/getRoomStatusByDate")
    public ApiResponse<List<RoomCurrentStatusDTO>> getRoomCurrentStatusByDates(@RequestBody RoomSearchDTO roomSearchDTO) {
        List<RoomCurrentStatusDTO> roomTypeResponseDTOList = roomService.selectRoomCurrentStatusByType(roomSearchDTO);
        return ApiResponse.<List<RoomCurrentStatusDTO>>builder()
                .status(HttpStatus.OK.toString())
                .message("room list fetched successfully")
                .data(roomTypeResponseDTOList)
                .build();
    }

}
