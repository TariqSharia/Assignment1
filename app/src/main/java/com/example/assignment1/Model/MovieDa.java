package com.example.assignment1.Model;

import android.widget.TextView;

import com.example.assignment1.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

class MovieDa implements IMovieDa {
    private ArrayList<Movie> movies = new ArrayList<>();
    public MovieDa(){
        movies.add(new Movie("The Godfather", "Crime",1972));
        movies.add(new Movie("The Shawshank Redemption", "Drama",1994));
        movies.add(new Movie("Shindler's List", "Drama",1993));
        movies.add(new Movie("The GodFather Part 2", "Crime",1974));
        movies.add(new Movie("Toy Story 3", "Cartoon",2010));
        movies.add(new Movie("Kingsman: The Secret Service", "Action",2015));
        movies.add(new Movie("Chinatown", "Thriller",1974));
        movies.add(new Movie("Gladiator", "Adventure",2000));
        movies.add(new Movie("Titanic", "Romance",1997));
        movies.add(new Movie("Get Out", "Horror",2017));
        movies.add(new Movie("Invictus", "Historical",2009));
        movies.add(new Movie("Death at a Funeral", "Comedy",2010));
        movies.add(new Movie("Furious 7", "Action",2015));
        movies.add(new Movie("Fast 5", "Action",2011));
    }

    @Override
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public ArrayList<Movie> search(String name, String genre, int year) {
        ArrayList<Movie> data = new ArrayList<>();
        Movie search_movie = new Movie(name, genre, year);
        if (name.equals("") && genre.equals("None") && year!=-1){
            for(Movie m:movies){
                if(year == m.getYear()){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }else if (name.equals("") && !genre.equals("None") && year==-1){
            for(Movie m:movies){
                if((m.getGenre().equals(genre))){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }else if (name.equals("") && !genre.equals("None") && year!=-1){
            for(Movie m:movies){
                if((m.getGenre().equals(genre)) && year == m.getYear()){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }else if (!name.equals("") && genre.equals("None") && year==-1){
            for(Movie m:movies){
                if((m.getMovie_name().toLowerCase()).contains((name).toLowerCase())){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }else if (!name.equals("") && genre.equals("None") && year!=-1){
            for(Movie m:movies){
                if((m.getMovie_name().toLowerCase()).contains((name).toLowerCase()) && year == m.getYear()){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }else if (!name.equals("") && !genre.equals("None") && year==-1){
            for(Movie m:movies){
                if((m.getMovie_name().toLowerCase()).contains((name).toLowerCase()) && (m.getGenre().equals(genre))){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }else{
            for(Movie m:movies){
                if((m.getMovie_name().toLowerCase()).contains((name).toLowerCase()) && year == m.getYear() && (m.getGenre().equals(genre))){
                    data.add(m);
                    System.out.println(m.toString());
                }
            }
        }
        return data;
    }

    @Override
    public ArrayList<String> getGenres() {
        ArrayList<String> genres = new ArrayList<>();
        genres.add("None");
        genres.add("Action");
        genres.add("Adventure");
        genres.add("Comedy");
        genres.add("Crime");
        genres.add("Drama");
        genres.add("Fantasy");
        genres.add("Historical");
        genres.add("Horror");
        genres.add("Mystery");
        genres.add("Fiction");
        genres.add("Romance");
        genres.add("Thriller");
        genres.add("Cartoon");
        return genres;
    }
}
