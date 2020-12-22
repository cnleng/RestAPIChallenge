package com.cnleng.controllers;

import com.cnleng.services.IBookingService;
import com.cnleng.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.URL_BOOKING)
public class BookingController {

    @Autowired
    @Qualifier("BookingService")
    private IBookingService bookingService;

    @RequestMapping(method = RequestMethod.POST)
    public void createBooking() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public void getBooking() {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateBooking() {

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteBooking() {

    }

}
