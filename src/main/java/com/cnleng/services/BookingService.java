package com.cnleng.services;

import com.cnleng.dao.IBookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BookingService")
public class BookingService implements IBookingService {

    @Autowired
    private IBookingDAO bookingDAO;

}
