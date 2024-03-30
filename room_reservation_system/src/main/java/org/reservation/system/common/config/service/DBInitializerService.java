package org.reservation.system.common.config.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
import java.math.RoundingMode;
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

        for (int i = 0; i < 31; i++) {
            RoomType targetRoomType = null;
            if (i < 15) {
                targetRoomType = roomTypeA;
            } else if (i >= 15 && i <= 28) {
                targetRoomType = roomTypeB;
            } else {
                targetRoomType = roomTypeC;
            }

            BigDecimal multiply = new BigDecimal(100000).multiply(new BigDecimal(i + 1)).setScale(0, RoundingMode.DOWN);
            Fee newFee = Fee.builder()
                    .feeAmount(multiply)
                    .feeName(targetRoomType.getRoomTypeCd() + "_Fee_" + (i + 1))
                    .roomType(targetRoomType)
                    .remark("remark_" + (i + 1)).build();
            em.persist(newFee);
        }
    }

    public void createReservationInfo() {
        List<RoomType> byDeletedIsFalsebyDeletedIsFalse = roomTypeRepository.findAll();
        List<Room> roomList = roomRepository.findAll();

        RoomType roomType = null;
        Room room = null;

        for(int i = 1; i <= 18; i++) {

            LocalDate enterRoomDate = LocalDate.now();
            LocalDate leaveRoomDate = LocalDate.now().plusDays(i);

            ReservationInfo.builder()
                    .reserverName("예약자_"+(i))
                    .reserverTelno("010-1234-5678")
                    .enterRoomDate(enterRoomDate)
                    .leaveRoomDate(leaveRoomDate)
                    .stayDayCnt(i)
                    .build();
        }

    }

}
