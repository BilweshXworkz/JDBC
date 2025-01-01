package com.xworkz.filmsapp.doa;


import java.sql.ResultSet;

public interface Films {
    public boolean addFilms(String title, int releaseYear, String genre, String director, int rating);
    public ResultSet getFilmsDetails();
    public int getUpdateFilmsById(String title, int releaseYear, int filmId);
    public ResultSet getByReleaseYearANDRating(int releaseYear, int rating);
    public ResultSet getByReleaseYearORRating(int releaseYear, int rating);
}