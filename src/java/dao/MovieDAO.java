/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.MovieDTO;
import utils.DbUtils;

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

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public MovieDAO() {
    }

    public List<MovieDTO> getLatestMovies() {
        String sql = "SELECT TOP 5 * FROM Movies ORDER BY release_date DESC";
        List<MovieDTO> list = new ArrayList<>();
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MovieDTO movie = new MovieDTO();
                movie.setMovieId(rs.getInt("movie_id"));
                movie.setTitle(rs.getString("title"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setReleaseDate(rs.getDate("release_date"));
                movie.setPosterUrl(rs.getString("poster_url"));
                movie.setTrailerUrl(rs.getString("trailer_url"));
                movie.setLanguage(rs.getString("language"));
                movie.setRated(rs.getString("rated"));
                movie.setStatus(rs.getString("status"));

                list.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return list;
    }

    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
