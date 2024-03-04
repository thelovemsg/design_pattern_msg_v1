package org.reservation.system.customer.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Embeddable
public class Address {

    @Size(min = 4, max = 6)
    private String zipCode;
    @NotNull
    @Column(length = 100)
    private String addr;
    @Column(length = 100)
    private String addrDetail;

}
