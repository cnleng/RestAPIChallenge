package com.cnleng.services;

import com.cnleng.api.request.BookingRequest;
import com.cnleng.exceptions.*;
import com.cnleng.model.Booking;
import org.joda.time.DateTime;

import java.util.List;

/**
 *
 */
public interface IBookingService {

    Booking getBookingById(Long id) throws BookingNotFoundException;

    List<Booking> getAllBookings(DateTime checkIn, DateTime checkOut) throws InvalidDateRangeException;

    Long createBooking(BookingRequest bookingRequest) throws BookingMaxDaysException, BookingNotAvailableException, InvalidDateRangeException, UserNotFoundException;

    Long updateBooking(BookingRequest bookingRequest) throws BookingMaxDaysException, BookingNotAvailableException, InvalidDateRangeException, BookingNotFoundException;

    void deleteBooking(Long id);

    List<Booking> getBookingByUserId(Long userId) throws UserNotFoundException;

    List<Booking> getAvailabilities(DateTime checkIn, DateTime checkOut) throws InvalidDateRangeException;
}
