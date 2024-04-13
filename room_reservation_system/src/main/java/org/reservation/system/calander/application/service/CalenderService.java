package org.reservation.system.calander.application.service;


import org.reservation.system.calander.domain.Calender;

import java.time.LocalDate;
import java.util.List;

public interface CalenderService {
    List<Calender> selectCalenderInfoBySolarDateBetween(LocalDate enterRoomDate, LocalDate leaveRoomDate);
    List<Calender> selectCalenderInfoBySolarDateExceptEndDate(LocalDate startDate, LocalDate endDate);
}
