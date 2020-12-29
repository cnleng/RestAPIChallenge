package com.cnleng.services;

import com.cnleng.api.request.BookingRequest;
import com.cnleng.dao.IBookingDAO;
import com.cnleng.dao.IUserDAO;
import com.cnleng.exceptions.*;
import com.cnleng.model.Booking;
import com.cnleng.model.User;
import com.cnleng.utils.DateUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("BookingService")
public class BookingService implements IBookingService {

    private final static Logger LOG = LoggerFactory.getLogger(BookingService.class);

    private final static int RESERVATION_MAX_DAYS = 3;
    private final static int ONE_MONTH = 1;

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IBookingDAO bookingDAO;

    @Override
    @Transactional
    public Booking getBookingById(Long id) throws BookingNotFoundException {
        try {
            return bookingDAO.findById(id).get();
        } catch (Exception e) {
            throw new BookingNotFoundException("Cannot find Reservation with Id = "+ id);
        }
    }

    @Override
    @Transactional
    public List<Booking> getAllBookings(DateTime checkIn, DateTime checkOut) throws InvalidDateRangeException {
        return this.getAvailabilities(checkIn, checkOut);
    }

    @Override
    @Transactional
    public Long createBooking(BookingRequest bookingRequest) throws BookingMaxDaysException, BookingNotAvailableException, InvalidDateRangeException, UserNotFoundException {
        User user;
        try {
            user = userDAO.findById(bookingRequest.getUserId()).get();
        } catch (Exception e) {
            throw new UserNotFoundException("Cannot find Reservation with Id = "+ bookingRequest.getUserId());
        }
        DateTime checkIn = DateUtils.convertToDateTime(bookingRequest.getCheckIn());
        DateTime checkOut = DateUtils.convertToDateTime(bookingRequest.getCheckOut());

        // Check campsite availabilities
        validateCheckInCheckOut(checkIn, checkOut);

        // Create and Link Booking
        Booking booking = new Booking();
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setUser(user);
        Booking result = bookingDAO.save(booking);
        return result.getId();
    }

    @Override
    @Transactional
    public Long updateBooking(BookingRequest bookingRequest) throws BookingMaxDaysException, BookingNotAvailableException, InvalidDateRangeException, BookingNotFoundException {
        Booking  booking;
        try {
            booking = bookingDAO.findById(bookingRequest.getId()).get();
        } catch (Exception e) {
            throw new BookingNotFoundException("Cannot find Reservation with Id = "+ bookingRequest.getId());
        }

        DateTime checkIn = DateUtils.convertToDateTime(bookingRequest.getCheckIn());
        DateTime checkOut = DateUtils.convertToDateTime(bookingRequest.getCheckOut());

        // Check campsite availabilities
        validateCheckInCheckOut(checkIn, checkOut);

        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        return booking.getId();
    }

    private void validateCheckInCheckOut(DateTime checkIn, DateTime checkOut) throws BookingNotAvailableException, BookingMaxDaysException, InvalidDateRangeException {
        List<Booking> bookings = this.getAvailabilities(checkIn, checkOut);
        if (!bookings.isEmpty()) {
            throw new BookingNotAvailableException("The campsite is not available. Check later");
        }

        int days = DateUtils.getDifferenceInDays(checkIn, checkOut);
        if (days > RESERVATION_MAX_DAYS) {
            throw new BookingMaxDaysException("The campsite can be reserved for max 3 days.");
        }

        DateTime defaultCheckIn = DateUtils.getDefaultCheckIn();
        DateTime maxDefaultCheckIn = DateUtils.getMonthAhead(DateTime.now(), ONE_MONTH);
        LOG.error(checkIn.toString());
        LOG.error(defaultCheckIn.toString());
        if ( (DateUtils.getDifferenceInDays(checkIn, defaultCheckIn)<1 && checkIn.isBefore(defaultCheckIn))
                || checkIn.isAfter(maxDefaultCheckIn)) {
            throw new BookingMaxDaysException("The campsite can be reserved minimum 1 day(s) ahead of arrival and up to 1 month in advance.");
        }
    }

    @Override
    @Transactional
    public void deleteBooking(Long id) {
        bookingDAO.deleteById(id);
    }

    @Override
    @Transactional
    public List<Booking> getBookingByUserId(Long userId) throws UserNotFoundException {
        User user;
        try {
            user = userDAO.findById(userId).get();
        } catch (Exception e) {
            throw new UserNotFoundException("Cannot find Reservation for user Id = "+ userId);
        }
        return user.getBookings();
    }

    @Override
    @Transactional
    public List<Booking> getAvailabilities(DateTime checkIn, DateTime checkOut) throws InvalidDateRangeException {
        if (DateUtils.isValidDateRange(checkIn, checkOut)) {
            return bookingDAO.findAvailabilities(checkIn, checkOut);
        } else {
            throw new InvalidDateRangeException("Check-In and Check-Out dates ranageare not valid");
        }

    }
}
