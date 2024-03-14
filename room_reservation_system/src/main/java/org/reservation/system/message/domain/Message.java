package org.reservation.system.message.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;
import org.reservation.system.reservation.domain.model.Reservation;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "T_MSG")
@AttributeOverride(name = "id", column = @Column(name = "msg_id"))
public class Message extends BaseEntity {

    private String name;
    private String telNo;
    private ZonedDateTime sendDate;
    private Boolean isSent;

    @OneToMany(mappedBy = "message", cascade = CascadeType.REMOVE)
    private List<MessageTag> messageTagList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rsvr_id")
    private Reservation reservation;

}
