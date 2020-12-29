package com.cnleng.controllers;

import com.cnleng.api.request.BookingRequest;
import com.cnleng.api.response.BookingListResponse;
import com.cnleng.api.response.BookingResponse;
import com.cnleng.model.Booking;
import com.cnleng.services.IBookingService;
import com.cnleng.utils.Constants;
import com.cnleng.utils.DateUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Constants.URL_BOOKING)
public class BookingController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
    private final static int ONE_MONTH = 1;

    @Autowired
    @Qualifier("BookingService")
    private IBookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBooking(@PathVariable Long id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            BookingResponse response = new BookingResponse("Reservation found.", booking.getId(),
                    DateUtils.convertFromDateTime(booking.getCheckIn()),
                    DateUtils.convertFromDateTime(booking.getCheckOut()));
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } catch (Exception e) {
            LOGGER.error("An error occurred while getting reservation", e);
            BookingResponse response = new BookingResponse("Cannot find reservation", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<BookingListResponse> getBookings(@RequestParam(required=false, name="checkIn")
                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) DateTime checkIn,
                                                           @RequestParam(required=false, name="checkOut")
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) DateTime checkOut) {

        try {
            if (checkIn == null || checkOut == null) {
                checkIn = DateUtils.getDefaultCheckIn();
                checkOut = DateUtils.getMonthAhead(checkIn, ONE_MONTH);
            }

            List<Booking> bookings = bookingService.getAllBookings(checkIn, checkOut);
            BookingListResponse response = null;
            if (!bookings.isEmpty()) {
                List<BookingResponse> responses = bookings.stream()
                        .map(b -> new BookingResponse("", b.getId(), DateUtils.convertFromDateTime(b.getCheckIn()),
                                DateUtils.convertFromDateTime(b.getCheckOut())))
                        .collect(Collectors.toList());
                response = new BookingListResponse("Successfully found reservations for date range.", responses);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response = new BookingListResponse("No reservations found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            LOGGER.error("An error occurred while getting reservations", e);
            BookingListResponse response = new BookingListResponse("An error occurred while getting reservations", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            Long bookingId = bookingService.createBooking(bookingRequest);
            BookingResponse response = new BookingResponse("Reservation successfully created", bookingId, null, null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error("An error occurred while booking reservation", e);
            BookingResponse userResponse = new BookingResponse("An error occurred while booking reservation", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingResponse> updateBooking(@RequestBody BookingRequest bookingRequest, @PathVariable Long id) {
        bookingRequest.setId(id);
        try {
            Long bookingId = bookingService.updateBooking(bookingRequest);
            BookingResponse response = new BookingResponse("Reservation successfully created", bookingId, null, null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error("An error occurred while updating reservation", e);
            BookingResponse userResponse = new BookingResponse("An error occurred while updating reservation", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingResponse> deleteBooking(@PathVariable Long id) {
        try {
            bookingService.deleteBooking(id);
            BookingResponse response = new BookingResponse("Reservation successfully cancelled");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        } catch (Exception e) {
            LOGGER.error("An error occurred while while cancelling reservation", e);
            BookingResponse response = new BookingResponse("An error occurred while cancelling reservation", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
