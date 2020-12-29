package com.cnleng.api.response;

public class BookingResponse extends ApiResponse {
    private Long bookingId;
    private String checkIn;
    private String checkOut;

    public BookingResponse(String message) {
        super(message);
    }

    public BookingResponse(String message, Exception error) {
        super(message, error);
    }

    public BookingResponse(String message, Long bookingId, String checkIn, String checkOut) {
        super(message);
        this.bookingId = bookingId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
