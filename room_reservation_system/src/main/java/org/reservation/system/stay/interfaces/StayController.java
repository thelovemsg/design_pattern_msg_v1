package org.reservation.system.stay.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.room.application.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class StayController {

    private final RoomTypeService roomTypeService;

    @GetMapping("/reservations")
    public String showReservationList(@ModelAttribute("reservationSearchDTO") ReservationSearchDTO reservationSearchDTO, Model model) {
        return "pages/stay/stayList";
    }


}
