package org.reservation.system.room.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.reservation.system.room.domain.model.Room;

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

    public static RoomDTO roomToDTO(Room room) {
        return RoomDTO
                .builder()
                .id(room.getId())
                .roomNo(room.getRoomNo())
                .roomName(room.getRoomName())
                .roomTypeCd(room.getRoomType().getRoomTypeCd())
                .build();
    }

}
