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
public class MovieDTO {
    private int movieId;
    private String title;
    private String description;
    private int duration;
    private Date releaseDate;
    private String posterUrl;
    private String trailerUrl;
    private String language;
    private String rated;
    private String status;

    public MovieDTO() {
    }

    public MovieDTO(int movieId, String title, String description, int duration, Date releaseDate, String posterUrl, String trailerUrl, String language, String rated, String status) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.posterUrl = posterUrl;
        this.trailerUrl = trailerUrl;
        this.language = language;
        this.rated = rated;
        this.status = status;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MovieDTO{" + "movieId=" + movieId + ", title=" + title + ", description=" + description + ", duration=" + duration + ", releaseDate=" + releaseDate + ", posterUrl=" + posterUrl + ", trailerUrl=" + trailerUrl + ", language=" + language + ", rated=" + rated + ", status=" + status + '}';
    }
}
