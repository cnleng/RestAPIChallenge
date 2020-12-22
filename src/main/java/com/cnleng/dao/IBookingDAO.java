package com.cnleng.dao;

import com.cnleng.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingDAO extends CrudRepository<Booking, Long> {
}
