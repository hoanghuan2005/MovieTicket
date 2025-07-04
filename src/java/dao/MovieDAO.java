/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SUPPER LOQ
 */
public class MovieDAO {

    private static final String GET_ALL_MOVIES = "SELECT * FROM Movies";
    private static final String GET_MOVIE_BY_ID = "SELECT * FROM Movies WHERE movie_id = ?";
    private static final String ADD_MOVIE = "INSERT INTO Movies (title, description, duration, release_date, poster_url, trailer_url, language, rated, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MOVIE = "UPDATE Movies SET title = ?, description = ?, duration = ?, release_date = ?, poster_url = ?, trailer_url = ?, language = ?, rated = ?, status = ? WHERE movie_id = ?";
    private static final String DELETE_MOVIE = "DELETE FROM Movies WHERE movie_id = ?";

}
