package org.reservation.system.customer.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.ZonedDateTime;

@Entity
@Table(name = "T_CUST")
@Getter
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
