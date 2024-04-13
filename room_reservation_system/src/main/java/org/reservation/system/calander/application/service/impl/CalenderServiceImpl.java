package org.reservation.system.calander.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.reservation.system.calander.application.service.CalenderService;
import org.reservation.system.calander.domain.Calender;
import org.reservation.system.calander.infrastructure.CalenderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderServiceImpl implements CalenderService {

    private final CalenderRepository calenderRepository;

    public List<Calender> selectCalenderInfoBySolarDateBetween(LocalDate startDate, LocalDate endDate) {
        return calenderRepository.findBySolarDateBetween(startDate, endDate);
    }
}
