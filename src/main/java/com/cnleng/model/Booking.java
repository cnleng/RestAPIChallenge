package com.cnleng.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime checkIn;
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Booking() {
    }

    public Booking(DateTime checkIn, DateTime checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
