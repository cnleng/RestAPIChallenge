package com.cnleng.model;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private DateTime checkIn;
    private DateTime checkOut;

    public Booking() {
    }

    public Booking(Long id, DateTime checkIn, DateTime checkOut) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(DateTime checkIn) {
        this.checkIn = checkIn;
    }

    public DateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(DateTime checkOut) {
        this.checkOut = checkOut;
    }

}
