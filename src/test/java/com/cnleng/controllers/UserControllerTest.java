package com.cnleng.controllers;

import com.cnleng.Application;
import com.cnleng.api.request.BookingRequest;
import com.cnleng.api.request.UserRequest;
import com.cnleng.api.response.BookingListResponse;
import com.cnleng.api.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Application.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql({ "classpath:schema.sql","classpath:data.sql" })
public class UserControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateUser() {
        LOGGER.info("testCreateUser()");
        UserRequest request = new UserRequest("Cyril.Henry", "cyril.henry@mail.com");
        ResponseEntity<UserResponse> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/users", request, UserResponse.class);
        assertEquals("User successfully created", responseEntity.getBody().getMessage());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetUserBookings() {
        LOGGER.info("testGetUserBookings()");
        BookingRequest request = new BookingRequest();
        ResponseEntity<BookingListResponse> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/users/1/bookings", BookingListResponse.class);
        assertEquals(3,responseEntity.getBody().getBookingResponses().size());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
