package org.reservation.system.calander.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.reservation.system.common.entity.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "T_CLND", indexes = {
        @Index(name = "idx_clnd_id", columnList = "clnd_id")
})
@AttributeOverride(name = "id", column = @Column(name = "clnd_id"))
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calender extends BaseEntity {
    private String dayDivCd;
    private String holidayDivCd;
    private String seasonDivCd;
    private String name;
    private LocalDate solarDate;
}
