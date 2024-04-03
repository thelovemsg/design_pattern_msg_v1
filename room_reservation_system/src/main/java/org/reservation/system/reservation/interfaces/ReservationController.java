package org.reservation.system.reservation.interfaces;

import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.application.service.ReservationService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservation/new")
    public String showReservationForm(@ModelAttribute("reservationSearchDTO") ReservationSearchDTO reservationSearchDTO, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        return "/reservation/reservationForm";
    }

}
