package com.cnleng.api.response;

import java.util.ArrayList;
import java.util.List;

public class BookingListResponse extends ApiResponse {

    private List<BookingResponse> bookingResponses = new ArrayList<>();

    public BookingListResponse() {
        super();
    }

    public BookingListResponse(String message) {
        super(message);
    }

    public BookingListResponse(String message, String error) {
        super(message, error);
    }

    public BookingListResponse(String message, List<BookingResponse> bookingResponses) {
        super(message);
        this.bookingResponses = bookingResponses;
    }

    public List<BookingResponse> getBookingResponses() {
        return bookingResponses;
    }

    public void setBookingResponses(List<BookingResponse> bookingResponses) {
        this.bookingResponses = bookingResponses;
    }
}
