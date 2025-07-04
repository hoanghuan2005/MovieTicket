/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SUPPER LOQ
 */
public class ShowtimeDAO {

    private static final String GET_ALL_SHOWTIMES = "SELECT * FROM Showtimes";
    private static final String GET_SHOWTIME_BY_ID = "SELECT * FROM Showtimes WHERE showtime_id = ?";
    private static final String ADD_SHOWTIME = "INSERT INTO Showtimes (movie_id, room_id, start_time, price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SHOWTIME = "UPDATE Showtimes SET movie_id = ?, room_id = ?, start_time = ?, price = ? WHERE showtime_id = ?";
    private static final String DELETE_SHOWTIME = "DELETE FROM Showtimes WHERE showtime_id = ?";

}
