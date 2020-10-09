package com.example.assignment1.Model;

public class Movie {
    private String movie_name, genre;
    private int year;

    public Movie(String movie_name, String genre, int year) {
        this.movie_name = movie_name;
        this.genre = genre;
        this.year = year;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  "movie_name='" + movie_name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year ;
    }
}
