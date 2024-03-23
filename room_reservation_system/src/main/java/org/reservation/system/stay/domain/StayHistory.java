package org.reservation.system.stay.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.reservation.system.common.entity.BaseEntity;

@Getter
@Entity
@Table(name = "T_STAY_HST", indexes = {
        @Index(name = "idx_stay_hst_id", columnList = "stay_hst_id")
})
@AttributeOverride(name = "id", column = @Column(name = "stay_hst_id"))
public class StayHistory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "stay_id")
    private Stay stay;

}