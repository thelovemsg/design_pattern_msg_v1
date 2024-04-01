package org.reservation.system.common.config.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.domain.model.Fee;
import org.reservation.system.reservation.domain.model.value.ReservationInfo;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.domain.repository.RoomRepository;
import org.reservation.system.room.domain.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBInitializerService {


    private final EntityManager em;
    private final RoomTypeRepository roomTypeRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public void createRoomInfo() {
        RoomType roomTypeA = new RoomType("Type_A");
        RoomType roomTypeB = new RoomType("Type_B");
        RoomType roomTypeC = new RoomType("Type_C");

        em.persist(roomTypeA);
        em.persist(roomTypeB);
        em.persist(roomTypeC);

        for (int i = 0; i < 35; i++) {
            if (i < 10) {
                em.persist(Room.builder().roomNo(1000 + i + 1)
                        .roomType(roomTypeA)
                        .roomName("Type_A_" + i)
                        .remark("룸타입A_" + i)
                        .build());
            } else if (i >= 10 && i < 20) {
                em.persist(Room.builder().roomNo(1000 + i + 1)
                        .roomType(roomTypeB)
                        .roomName("Type_B_" + i)
                        .remark("룸타입B_" + i)
                        .build());
            } else {
                em.persist(Room.builder().roomNo(1000 + i + 1)
                        .roomType(roomTypeC)
                        .roomName("Type_C_" + i)
                        .remark("룸타입C_" + i)
                        .build());
            }

        }


        BigDecimal feeAmountA = new BigDecimal(100000);
        Fee newFeeA = Fee.builder()
                .feeAmount(feeAmountA)
                .feeName(roomTypeA.getRoomTypeCd() + "_Fee_A")
                .roomType(roomTypeA)
                .remark("remark_" + roomTypeA.getRoomTypeCd()).build();
        em.persist(newFeeA);

        BigDecimal feeAmountB = new BigDecimal(150000);
        Fee newFeeB = Fee.builder()
                .feeAmount(feeAmountB)
                .feeName(roomTypeB.getRoomTypeCd() + "_Fee_B")
                .roomType(roomTypeB)
                .remark("remark_" + roomTypeB.getRoomTypeCd()).build();
        em.persist(newFeeB);

        BigDecimal feeAmountC = new BigDecimal(200000);
        Fee newFeeC = Fee.builder()
                .feeAmount(feeAmountC)
                .feeName(roomTypeC.getRoomTypeCd() + "_Fee")
                .roomType(roomTypeC)
                .remark("remark_" + roomTypeC.getRoomTypeCd()).build();
        em.persist(newFeeC);

    }

    public void createReservationInfo() {
        List<RoomType> byDeletedIsFalsebyDeletedIsFalse = roomTypeRepository.findAll();
        List<Room> roomList = roomRepository.findAll();

        RoomType roomType = null;
        Room room = null;

        for (int i = 1; i <= 18; i++) {

            LocalDate enterRoomDate = LocalDate.now();
            LocalDate leaveRoomDate = LocalDate.now().plusDays(i);

            ReservationInfo.builder()
                    .reserverName("예약자_" + (i))
                    .reserverTelno("010-1234-5678")
                    .enterRoomDate(enterRoomDate)
                    .leaveRoomDate(leaveRoomDate)
                    .stayDayCnt(i)
                    .build();
        }

    }

}
