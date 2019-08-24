package com.example.katalogfilm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.katalogfilm.Model.Film;

public class DetailActivity extends AppCompatActivity {
    public static final String KEY_EXTRA = "KEY_EXTRA";
    private int photo;
    ImageView imgPhoto;
    TextView txtTitle, txtSpoiler, txtGenre, txtReleased;
    private String title, spoiler, genre, released;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgPhoto = findViewById(R.id.item_photo);
        txtTitle = findViewById(R.id.title);
        txtReleased = findViewById(R.id.year_movie);
        txtSpoiler = findViewById(R.id.spoiler);
        txtGenre = findViewById(R.id.genre);

        IntentData();

    }

    private void IntentData() {
        Film film = getIntent().getParcelableExtra(KEY_EXTRA);
        photo = film.getPhoto();
        title = film.getTitle();
        spoiler = film.getSpoiler();
        genre = film.getGenre();
        released = film.getReleased();

        imgPhoto.setImageResource(photo);
        txtTitle.setText(title);
        txtSpoiler.setText(spoiler);
        txtGenre.setText(genre);
        txtReleased.setText(released);

    }
}
