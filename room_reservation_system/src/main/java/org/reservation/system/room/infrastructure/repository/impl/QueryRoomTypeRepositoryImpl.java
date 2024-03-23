package org.reservation.system.room.infrastructure.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.reservation.system.fee.domain.model.QFee;
import org.reservation.system.room.domain.model.QRoom;
import org.reservation.system.room.domain.model.QRoomType;
import org.reservation.system.room.domain.model.Room;
import org.reservation.system.room.domain.model.RoomType;
import org.reservation.system.room.infrastructure.repository.QueryRoomTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryRoomTypeRepositoryImpl implements QueryRoomTypeRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Room> findRoomWithType(RoomType roomType) {
        return jpaQueryFactory.selectFrom(QRoom.room)
                .join(QRoom.room.roomType, QRoomType.roomType)
                .where(QRoom.room.roomType.eq(roomType))
                .fetch();
    }

    @Override
    public List<RoomType> findFeeWithType(RoomType roomType) {
        return jpaQueryFactory.selectFrom(QRoomType.roomType)
                .join(QFee.fee).fetch();
    }

}
