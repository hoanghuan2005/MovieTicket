/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SUPPER LOQ
 */
public class BookingDAO {

    private static final String GET_BOOKINGS_BY_USER_ID = "SELECT * FROM Bookings WHERE user_id = ?";
    private static final String GET_BOOKING_DETAILS = "SELECT * FROM BookingDetails WHERE booking_id = ?";
    private static final String ADD_BOOKING = "INSERT INTO Bookings (user_id, showtime_id, booking_time, total_amount, status) VALUES (?, ?, GETDATE(), ?, ?)";
    private static final String ADD_BOOKING_DETAIL = "INSERT INTO BookingDetails (booking_id, seat_id, price) VALUES (?, ?, ?)";
    private static final String GET_ALL_BOOKINGS = "SELECT * FROM Bookings";
    private static final String CANCEL_BOOKING = "UPDATE Bookings SET status = 'Cancelled' WHERE booking_id = ?";

}
