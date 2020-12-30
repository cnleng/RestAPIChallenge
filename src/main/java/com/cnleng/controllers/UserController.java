package com.cnleng.controllers;

import com.cnleng.api.request.UserRequest;
import com.cnleng.api.response.BookingListResponse;
import com.cnleng.api.response.BookingResponse;
import com.cnleng.api.response.UserResponse;
import com.cnleng.model.Booking;
import com.cnleng.services.IBookingService;
import com.cnleng.services.IUserService;
import com.cnleng.utils.Constants;
import com.cnleng.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = Constants.URL_USER)
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("UserService")
    private IUserService userService;

    @Autowired
    @Qualifier("BookingService")
    private IBookingService bookingService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) {
        try {
            Long userId = userService.createUser(user);
            UserResponse userResponse = new UserResponse("User successfully created", userId, "", "");
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            LOGGER.error("An error occurred while creating user", e);
            UserResponse userResponse = new UserResponse("An error occurred while creating user",
                    e.getClass().getTypeName());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            LOGGER.error("An error occurred while deleting user", e);
            UserResponse response = new UserResponse("An error occurred while deleting user", e.getClass().getTypeName());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
    }

    @GetMapping("/{userId}"+Constants.URL_BOOKING)
    public ResponseEntity<BookingListResponse> getBookings(@PathVariable Long userId) {
        try {
            List<Booking> bookings = bookingService.getBookingByUserId(userId);
            BookingListResponse response = null;
            if (!bookings.isEmpty()) {
                List<BookingResponse> responses = bookings.stream()
                        .map(b -> new BookingResponse("", b.getId(),
                                DateUtils.convertFromDateTime(b.getCheckIn()),
                                DateUtils.convertFromDateTime(b.getCheckOut())))
                        .collect(Collectors.toList());
                response = new BookingListResponse("Successfully found reservations for user.", responses);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response = new BookingListResponse("No reservations found for user.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            LOGGER.error("An error occurred while getting user's reservations", e);
            BookingListResponse response = new BookingListResponse("An error occurred while getting user's reservations",
                    e.getClass().getTypeName());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
