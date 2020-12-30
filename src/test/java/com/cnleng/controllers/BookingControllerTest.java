package com.cnleng.controllers;

import com.cnleng.Application;
import com.cnleng.api.request.BookingRequest;
import com.cnleng.api.response.BookingListResponse;
import com.cnleng.api.response.BookingResponse;
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
public class BookingControllerTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final static String checkIn = "2021-01-08";
    private final static String checkOut = "2021-01-10";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetBooking() {
        LOGGER.info("testGetBooking()");
        BookingRequest request = new BookingRequest();
        ResponseEntity<BookingResponse> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/bookings/1", BookingResponse.class);
        assertEquals("Reservation found.", responseEntity.getBody().getMessage());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testCreateBooking() {
        LOGGER.info("testCreateBooking()");
        BookingRequest request = new BookingRequest( 0L, 1L, checkIn, checkOut);
        ResponseEntity<BookingResponse> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/bookings", request, BookingResponse.class);
        assertEquals("Reservation successfully created", responseEntity.getBody().getMessage());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testUpdateBooking() {
        LOGGER.info("testUpdateBooking()");
        BookingRequest request = new BookingRequest( 1L, 1L, checkIn, checkOut);
        restTemplate.put("http://localhost:" + port + "/bookings/1", request);
        ResponseEntity<BookingResponse> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/bookings/1", BookingResponse.class);
        assertEquals(checkIn, responseEntity.getBody().getCheckIn());
        assertEquals(checkOut, responseEntity.getBody().getCheckOut());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testAllBookings()
    {
        LOGGER.info("testAllBookings()");
        ResponseEntity<BookingListResponse> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/bookings", BookingListResponse.class);
        assertEquals(3, responseEntity.getBody().getBookingResponses().size());
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testDeleteBooking() {
        LOGGER.info("testDeleteBooking()");
        restTemplate.delete("http://localhost:" + port + "/bookings/1");
        ResponseEntity<BookingResponse> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/bookings/1", BookingResponse.class);
        assertEquals(500, responseEntity.getStatusCodeValue());
    }

}
