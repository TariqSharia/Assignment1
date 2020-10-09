package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment1.Model.IMovieDa;
import com.example.assignment1.Model.Movie;
import com.example.assignment1.Model.MovieFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText movie_edt_txt, year_edt_txt;
    private TextView output_area;
    private ArrayList<Movie> movies = new ArrayList<>();
    private  int num_of_tries=0;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById((R.id.movie_genre));
        movie_edt_txt = findViewById(R.id.name_edt);
        output_area = findViewById(R.id.output_area);
        year_edt_txt = findViewById(R.id.year_edt);
        imageView = findViewById(R.id.img_view);
        populateSpinner();
    }


    private void populateSpinner(){
        MovieFactory factory = new MovieFactory();
        IMovieDa objMovies = factory.getModel();
        ArrayList genres = objMovies.getGenres();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,genres);
        spinner.setAdapter(adapter);
    }

    public void searchForMovies(View view) {
        MovieFactory factory = new MovieFactory();
        IMovieDa objMovie = factory.getModel();
        output_area.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
        int i =1;
        String result = "";
        output_area.setText("");
        if (num_of_tries!=0){
            movies.clear();
        }
        if (year_edt_txt.getText().toString().equals("") && movie_edt_txt.getText().toString().equals("")
                && spinner.getSelectedItem().toString().equalsIgnoreCase("None")){
            movies = objMovie.getMovies();
            Toast.makeText(this, "Nothing selected", Toast.LENGTH_LONG).show();
        }else {
            String name = movie_edt_txt.getText().toString();
            String genre = spinner.getSelectedItem().toString();
            int year;
            if (TextUtils.isEmpty(year_edt_txt.getText().toString())) {
                year = -1;
            }else{
                year = Integer.parseInt(year_edt_txt.getText().toString());
            }
            movies = objMovie.search(name, genre, year);
        }

        if (movies.size()==0){
            result="NO movies matches the requirements but here are some cool movies to watch \n\n";
            movies = objMovie.getMovies();
        }
        for (Movie m : movies) {
            result+= (i++) +"- " + m.toString() + "\n";
        }
        num_of_tries++;
        output_area.setText(result);
    }
}