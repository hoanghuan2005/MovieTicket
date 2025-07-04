/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SUPPER LOQ
 */
public class CinemaDAO {

    private static final String GET_ALL_CINEMAS = "SELECT * FROM Cinemas";
    private static final String GET_CINEMA_BY_ID = "SELECT * FROM Cinemas WHERE cinema_id = ?";
    private static final String ADD_CINEMA = "INSERT INTO Cinemas (name, address, city, phone) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CINEMA = "UPDATE Cinemas SET name = ?, address = ?, city = ?, phone = ? WHERE cinema_id = ?";
    private static final String DELETE_CINEMA = "DELETE FROM Cinemas WHERE cinema_id = ?";

}
