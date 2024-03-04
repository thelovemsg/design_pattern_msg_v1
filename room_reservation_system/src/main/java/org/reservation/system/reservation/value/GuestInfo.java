package org.reservation.system.reservation.value;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.reservation.system.reservation.enums.ReservationMethodEnum;

import static jakarta.persistence.EnumType.STRING;

@Embeddable
@Getter
public class GuestInfo {
    private String name;
    private String telNo;
    @Enumerated(STRING)
    private ReservationMethodEnum reservationMethod;
}
