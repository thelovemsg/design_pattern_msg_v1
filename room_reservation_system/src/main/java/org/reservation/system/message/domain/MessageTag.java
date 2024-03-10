package org.reservation.system.message.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "T_MSG_TAG")
@AttributeOverride(name = "id", column = @Column(name = "msg_tag_id"))
public class MessageTag extends BaseEntity {

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "msg_id")
    private Message message;

    private String sequence;
    private String value;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "msg_tmpl_id")
    private MessageTemplate messageTemplate;
}
