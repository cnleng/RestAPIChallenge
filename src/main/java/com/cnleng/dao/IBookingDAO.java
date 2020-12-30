package com.cnleng.dao;

import com.cnleng.model.Booking;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingDAO extends CrudRepository<Booking, Long> {

    @Query(value = "SELECT b FROM Booking b where (b.checkIn >= :checkIn and b.checkIn <= :checkOut) or (b.checkOut >= :checkIn and b.checkOut <= :checkOut)")
    List<Booking> findAvailabilities(@Param("checkIn") DateTime checkIn, @Param("checkOut") DateTime checkOut);

    @Query(value = "SELECT b FROM Booking b where b.user.id = :userId")
    List<Booking> findBookingByUserId(@Param("userId") Long userId);
}
