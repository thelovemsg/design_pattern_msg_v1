package org.reservation.system.room.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreationDTO {

    @NotNull(message = "{room.no.notBlank}")
    private Integer roomNo;
    @NotBlank(message = "{room.name.notBlank}")
    private String roomName;
    @NotBlank(message = "{room.name.notBlank}")
    private String roomType;
    private String remark;

}
