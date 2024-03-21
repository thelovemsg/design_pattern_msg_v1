package org.reservation.system.common.config.jpa;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.createRoomInfo();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void createRoomInfo() {
            RoomType roomTypeA = new RoomType("Type_A");
            RoomType roomTypeB = new RoomType("Type_B");
            RoomType roomTypeC = new RoomType("Type_C");

            em.persist(roomTypeA);
            em.persist(roomTypeB);
            em.persist(roomTypeC);

            for (int i = 0; i < 35; i++) {
                if(i<10) {
                    em.persist(Room.builder().roomNo(1000+i+1)
                            .roomType(roomTypeA)
                            .roomName("Type_A_"+i)
                            .remark("룸타입A_"+i)
                            .build());
                } else if(i >= 10 && i < 20) {
                    em.persist(Room.builder().roomNo(1000+i+1)
                            .roomType(roomTypeB)
                            .roomName("Type_B_"+i)
                            .remark("룸타입B_"+i)
                            .build());
                } else {
                    em.persist(Room.builder().roomNo(1000+i+1)
                            .roomType(roomTypeC)
                            .roomName("Type_C_"+i)
                            .remark("룸타입C_"+i)
                            .build());
                }

            }


        }

    }

}
