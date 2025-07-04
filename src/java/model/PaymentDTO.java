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
public class PaymentDTO {

    private int paymentId;
    private int bookingId;
    private String paymentMethod;
    private Date paymentTime;
    private double amount;
    private String status;

    public PaymentDTO() {
    }

    public PaymentDTO(int paymentId, int bookingId, String paymentMethod, Date paymentTime, double amount, String status) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "paymentId=" + paymentId + ", bookingId=" + bookingId + ", paymentMethod=" + paymentMethod + ", paymentTime=" + paymentTime + ", amount=" + amount + ", status=" + status + '}';
    }
}
