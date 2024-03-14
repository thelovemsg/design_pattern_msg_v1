package org.reservation.system.calander.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "T_CLND")
@AttributeOverride(name = "id", column = @Column(name = "clnd_id"))
public class Calender extends BaseEntity {
    private String dayDivCd;
    private String peakDivCd;
    private String seasonDivCd;
    private LocalDate solarDate;
    private LocalDate lunarDate;
}
