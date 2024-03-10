package org.reservation.system.message.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.reservation.system.common.entity.BaseEntity;

import java.util.List;

@Entity
@Getter
@Table(name = "T_MSG_TMPL")
@AttributeOverride(name = "id", column = @Column(name = "msg_tmpl_id"))
public class MessageTemplate extends BaseEntity {

    private String name;
    private String templateType;
    private String content;
    private String variant1;
    private String variant2;
    private String variant3;
    private String variant4;
    private String variant5;
    private String variant6;
    private String variant7;
    private String variant8;

    @OneToMany(mappedBy = "messageTemplate")
    private List<MessageTag> messageTagList;
}
