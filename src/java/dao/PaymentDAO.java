/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SUPPER LOQ
 */
public class PaymentDAO {

    private static final String ADD_PAYMENT = "INSERT INTO Payments (booking_id, payment_method, payment_time, amount, status) VALUES (?, ?, GETDATE(), ?, ?)";
    private static final String GET_PAYMENT_BY_BOOKING_ID = "SELECT * FROM Payments WHERE booking_id = ?";
    private static final String UPDATE_PAYMENT_STATUS = "UPDATE Payments SET status = ? WHERE payment_id = ?";

}
