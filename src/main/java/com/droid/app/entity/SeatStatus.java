package com.droid.app.entity;

/**
 * Created by vinay on 19/8/16.
 */
public class SeatStatus {

    private String bookingStatus;
    private String currentStatus;

    public SeatStatus(String bookingStatus, String currentStatus) {
        this.bookingStatus = bookingStatus;
        this.currentStatus = currentStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }
}
