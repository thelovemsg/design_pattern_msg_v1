package org.reservation.system.customer.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.customer.value.Address;

import java.time.ZonedDateTime;

@Entity
@Table(name = "T_CUST")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "cust_id"))
public class Customer extends BaseEntity {

    @NotNull
    private String name;
    @NotNull
    private String telNo;
    @Email
    private String email;
    @Embedded
    private Address address;
    private ZonedDateTime signInDateTime;

}
