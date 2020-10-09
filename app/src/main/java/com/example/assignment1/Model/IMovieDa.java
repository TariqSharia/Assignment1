package com.example.assignment1.Model;

import java.util.ArrayList;

public interface IMovieDa {

    ArrayList<Movie> getMovies();
    ArrayList<Movie> search(String name, String genre, int year);

    ArrayList<String> getGenres();
}
