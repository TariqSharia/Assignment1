package com.example.assignment1.Model;

public class MovieFactory {

    public IMovieDa getModel(){
        return new MovieDa();
    }
}
