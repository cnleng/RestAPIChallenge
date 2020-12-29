package com.cnleng.api.request;

public class BookingRequest extends ApiRequest {

    private Long id;
    private String checkIn;
    private String checkOut;
    private Long userId;

    public BookingRequest() {
    }

    public BookingRequest(Long id, Long userId, String checkIn, String checkOut) {
        this.id = id;
        this.userId = userId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
