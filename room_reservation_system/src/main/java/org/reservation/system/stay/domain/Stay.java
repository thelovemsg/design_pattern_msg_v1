package org.reservation.system.stay.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.reservation.value.ReservationInfo;
import org.reservation.system.stay.domain.other.RoomStay;
import org.reservation.system.stay.enums.CheckinDivEnum;
import org.reservation.system.stay.enums.StayStusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@AttributeOverride(name = "id", column = @Column(name = "stay_id"))
public class Stay extends BaseEntity {

    @Embedded
    private ReservationInfo reservationInfo;

    @Enumerated(EnumType.STRING)
    private CheckinDivEnum checkinDivCd;

    @OneToMany(mappedBy = "stay")
    private List<StayHistory> stayHistoryList;

    @OneToMany(mappedBy = "stay")
    private List<RoomStay> roomStayList;

}
