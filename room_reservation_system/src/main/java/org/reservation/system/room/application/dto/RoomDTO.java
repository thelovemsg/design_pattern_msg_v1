package org.reservation.system.room.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    @NotNull(message = "{room.no.notBlank}")
    private Integer roomNo;
    @NotBlank(message = "{room.name.notBlank}")
    private String roomName;
    @NotBlank(message = "{room.type.notBlank}")
    private String roomTypeCd;
    private String remark;

}
