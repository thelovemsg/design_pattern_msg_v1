package org.reservation.system.calander.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "T_CLND", indexes = {
        @Index(name = "idx_clnd_id", columnList = "clnd_id")
})
@AttributeOverride(name = "id", column = @Column(name = "clnd_id"))
public class Calender extends BaseEntity {
    private String dayDivCd;
    private String peakDivCd;
    private String seasonDivCd;
    private LocalDate solarDate;
    private LocalDate lunarDate;
}
