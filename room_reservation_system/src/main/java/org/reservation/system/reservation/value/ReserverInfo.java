package org.reservation.system.reservation.value;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class ReserverInfo {

    private String telNo;
    private String name;

}
