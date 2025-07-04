/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SUPPER LOQ
 */
public class BookingDetailDTO {

    private int bookingId;
    private int seatId;
    private double price;

    public BookingDetailDTO() {
    }

    public BookingDetailDTO(int bookingId, int seatId, double price) {
        this.bookingId = bookingId;
        this.seatId = seatId;
        this.price = price;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookingDetailDTO{" + "bookingId=" + bookingId + ", seatId=" + seatId + ", price=" + price + '}';
    }
}
