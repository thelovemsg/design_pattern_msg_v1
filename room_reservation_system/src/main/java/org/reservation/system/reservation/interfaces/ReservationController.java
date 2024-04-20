package org.reservation.system.reservation.interfaces;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.reservation.system.reservation.application.dto.ReservationCreationDTO;
import org.reservation.system.reservation.application.dto.ReservationDTO;
import org.reservation.system.reservation.application.dto.ReservationSearchDTO;
import org.reservation.system.reservation.application.service.ReservationService;
import org.reservation.system.reservation.domain.model.Reservation;
import org.reservation.system.reservation.domain.repository.ReservationRepository;
import org.reservation.system.room.application.dto.RoomTypeResponseDTO;
import org.reservation.system.room.application.service.RoomTypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final RoomTypeService roomTypeService;
    private final ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public String showReservationList(@ModelAttribute("reservationSearchDTO") ReservationSearchDTO reservationSearchDTO, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);
        return "pages/reservation/reservationList";
    }

    @GetMapping("/reservations/new")
    public String showNewReservationForm(@ModelAttribute("reservationDTO") ReservationDTO reservationDTO, Model model) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);
        model.addAttribute("reservationDTO", new ReservationDTO());
        return "pages/reservation/reservationForm";
    }

    @PostMapping("/reservations/new")
    public String saveReservationForm(@ModelAttribute("reservationDTO") @Valid ReservationDTO reservationDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        if (bindingResult.hasErrors()) {
            model.addAttribute("reservationDTO", reservationDTO);
            return "/pages/reservation/reservationForm";
        }

        ReservationDTO newReservationDTO = reservationService.makeRoomReservation(reservationDTO);

        redirectAttributes.addFlashAttribute("successMessage", "생성 성공!");

        return "redirect:/reservations/update" + newReservationDTO.getId();
    }

    @GetMapping("/reservation/update/{id}")
    public String getUpdateReservationForm(@PathVariable("id") Long id, Model model) {
        ReservationDTO reservationResponse = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservationResponse);
        return "pages/reservation/updateReservation";
    }

    @PostMapping("/reservation/update")
    public String updateReservation(@ModelAttribute("ReservationDTO") ReservationDTO reservationDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        List<RoomTypeResponseDTO> roomTypeList = roomTypeService.selectAllRoomType();
        model.addAttribute("roomTypeList", roomTypeList);

        Optional<Reservation> reservationById = reservationRepository.findById(reservationDTO.getId());

        if (reservationById.isEmpty()) {
            bindingResult.rejectValue("id", "error.id", "reservation does not exist!");
        }



        if (bindingResult.hasErrors()) {
            return "pages/reservation/update";
        }

        reservationService.updateReservation(reservationById.get());
        model.addAttribute("reservationDTO", reservationDTO);
        redirectAttributes.addFlashAttribute("successMessage", "업데이트 성공!");

        return "redirect:/reservation/update/" + reservationDTO.getId();
    }

}
