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
public class ShowtimeDTO {

    private int showtimeId;
    private int movieId;
    private int roomId;
    private Date startTime;
    private double price;

    public ShowtimeDTO() {
    }

    public ShowtimeDTO(int showtimeId, int movieId, int roomId, Date startTime, double price) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.roomId = roomId;
        this.startTime = startTime;
        this.price = price;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShowtimeDTO{" + "showtimeId=" + showtimeId + ", movieId=" + movieId + ", roomId=" + roomId + ", startTime=" + startTime + ", price=" + price + '}';
    }
}
