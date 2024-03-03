package org.reservation.system.common.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "T_COMM_CODE")
@Getter
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class CommCode extends BaseEntity{

    private String groupCode;
    private String displayCode;
    private String displayName;
    private String lang;
}
