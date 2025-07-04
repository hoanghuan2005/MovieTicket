/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author SUPPER LOQ
 */
public class BookingDTO {

    private int bookingId;
    private int userId;
    private int showtimeId;
    private Date bookingTime;
    private double totalAmount;
    private String status;

    public BookingDTO() {
    }

    public BookingDTO(int bookingId, int userId, int showtimeId, Date bookingTime, double totalAmount, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.bookingTime = bookingTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingDTO{" + "bookingId=" + bookingId + ", userId=" + userId + ", showtimeId=" + showtimeId + ", bookingTime=" + bookingTime + ", totalAmount=" + totalAmount + ", status=" + status + '}';
    }

}
